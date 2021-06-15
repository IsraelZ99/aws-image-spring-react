package com.amigoscode.awsimageupload.filestore;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.S3Object;
import com.amazonaws.services.s3.model.S3ObjectInputStream;
import com.amazonaws.util.IOUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStream;
import java.util.Map;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class FileStore {

    @Autowired
    private final AmazonS3 s3;

    /**
     *
     * @param path Path of bucket (folder name)
     * @param fileName Name of file
     * @param optionalMetadata Metadata of the file
     * @param inputStream
     */
    public void save(String path, String fileName,
                     Optional<Map<String, String>> optionalMetadata,
                     InputStream inputStream){
        ObjectMetadata metadata = new ObjectMetadata();
        optionalMetadata.ifPresent(map -> {
            if(!map.isEmpty()){ map.forEach(metadata::addUserMetadata); }
        });
        try{
            s3.putObject(path, fileName, inputStream, metadata);
        } catch(AmazonServiceException e){
            throw new IllegalStateException("Failed to store file to s3", e);
        }

    }

    public byte[] download(String path, String key) {
        try{
            S3Object object = s3.getObject(path, key);
            return IOUtils.toByteArray(object.getObjectContent());
        }catch(AmazonServiceException | IOException e){
            throw new IllegalStateException("Failed to download file to s3", e);
        }
    }
}
