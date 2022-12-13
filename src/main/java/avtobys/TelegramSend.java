package avtobys;

import com.github.kevinsawicki.http.HttpRequest;
import org.apache.commons.io.IOUtils;
import org.testng.annotations.Test;

import java.io.*;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.Base64;
import static avtobys.variable.*;

public class TelegramSend {
    public void getpost(String textlog) throws Exception {


        // `HttpURLConnection` connection = (HttpURLConnection) url.openConnection();
        // connection.setRequestMethod("GET");

        String q = textlog;
        String urllog = logUrl + URLEncoder.encode(q, StandardCharsets.UTF_8);

        URL url = new URL(urllog);
        URLConnection connection = url.openConnection();


        try (BufferedReader in = new BufferedReader(
                new InputStreamReader(connection.getInputStream())))
        {
            String line;
            while ((line = in.readLine()) != null) {
                System.out.println(line);
            }
        }
    }

    @Test
    public void sendFile(String filepath, String filename, String testname) throws Exception {

        String base64="";
        try{
            InputStream iSteamReader = new FileInputStream(filepath);
            byte[] imageBytes = IOUtils.toByteArray(iSteamReader);
            base64 = Base64.getEncoder().encodeToString(imageBytes);
            //System.out.println(base64);
        }catch(Exception e){
            e.printStackTrace();
        }

        HttpRequest request = HttpRequest.post(urlUpload);
        request.part("filename", filename);
        request.part("photo", ""+base64);
        request.part("testname", testname);
        //request.part("file", new File("out/5.JPG"));
        int status = request.code();
        if(status == 200) {
            System.out.println(request.body());
        }
    }


}
