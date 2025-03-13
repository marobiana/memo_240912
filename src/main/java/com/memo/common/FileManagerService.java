package com.memo.common;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Slf4j
@Component  // spring bean
public class FileManagerService {
    // 실제 업로드 된 이미지 파일이 저장될 경로 지정
    public final static String FILE_UPLOAD_PATH = "/home/ec2-user/m_image/";

    // i: multipart file, userLoginId(폴더명으로 사용)
    // o: image Path(String)
    public String uploadFile(MultipartFile file, String loginId) {
        // 폴더(디렉토리) 생성
        // 예: aaaa_1723468798/sun.png
        String directoryName = loginId + "_" + System.currentTimeMillis();
        String filePath = FILE_UPLOAD_PATH + directoryName + "/"; //   D:\신보람\6_spring_project\m_images/aaaa_1723468798/

        // 폴더 생성
        File directory = new File(filePath);
        if (directory.mkdir() == false) {
            return null; // 폴더 생성시 실패하면 이미지 경로는 null로 리턴(에러 아님)
        }
        
        // 파일 업로드
        try {
            byte[] bytes = file.getBytes();
            //!!!!! 나중에 파일명을 웬만하면 영문자로 변경할 것(한글 업로드가 안 될 수 있음)
            Path path = Paths.get(filePath + file.getOriginalFilename()); // D:\신보람\6_spring_project\m_images/aaaa_1723468798/sun.png
            Files.write(path, bytes);
        } catch (IOException e) {
            e.printStackTrace(); // 에러 메시지 출력
            return null; // 이미지 업로드 실패시 이미지 경로는 null로 리턴(에러 아님)
        }

        // 파일업로드가 성공하면 이미지 url path 리턴
        // 주소는 이렇게 될 것이다.(예언)
        // 예: /images/aaaa_17485928104/sun.png
        return "/images/" + directoryName + "/" + file.getOriginalFilename();
    }

    // i: imagePath(String)
    // o: X
    public void deleteFile(String imagePath) {
        // as-is: D:\신보람\6_spring_project\m_images//images/aaaa_1736930788069/3fa7c20a9f4ce0b997fe0d007324214a.jpg
        // to-be: D:\신보람\6_spring_project\m_images/aaaa_1736930788069/3fa7c20a9f4ce0b997fe0d007324214a.jpg
        //     /images/ 겹치므로 제거
        Path path = Paths.get(FILE_UPLOAD_PATH + imagePath.replace("/images/", ""));

        // 삭제할 이미지가 존재하는가?
        if (Files.exists(path)) {
            // 이미지 삭제
            try {
                Files.delete(path);
            } catch (IOException e) {
                log.info("[### 파일매니저 image 삭제] imagePath:{}", imagePath);
                return;
            }

            // 디렉토리 삭제
            path = path.getParent();
            if (Files.exists(path)) {
                try {
                    Files.delete(path);
                } catch (IOException e) {
                    log.info("[### 파일매니저 directory 삭제] imagePath:{}", imagePath);
                }
            }
        }
    }
}
