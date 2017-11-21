package EmailWeather.Weather;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

public class HeWeather {
    public String GetWeather(String city){
        String api_key="fxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx";
        //String param = "key=xxxxxxxxxxxxxxxxxxx&location="+city;

        String param=String.format("key=%s&location=%s",api_key,city);
        StringBuilder sb = new StringBuilder();
        InputStream    is=null;
        BufferedReader br=null;

        String sbRet="";
        try {
            //接口地址
            String            url        = "https://free-api.heweather.com/s6/weather";
            URL uri        = new URL(url);
            HttpURLConnection connection= (HttpURLConnection) uri.openConnection();
            connection.setRequestMethod("POST");
            connection.setReadTimeout(5000);
            connection.setConnectTimeout(10000);
            connection.setRequestProperty("accept", "*/*");
            //发送参数
            connection.setDoOutput(true);
            PrintWriter out = new PrintWriter(connection.getOutputStream());
            out.print(param);
            out.flush();
            out.close();
            //接收结果
            is = connection.getInputStream();
            br = new BufferedReader(new InputStreamReader(is));
            String         line;
            //缓冲逐行读取
            while ( (line = br.readLine()) != null ) {
                sb.append(line);
            }

            sbRet=sb.toString();
        }catch ( Exception ignored ){}
        finally {
            //输出结果

            //关闭流
            try {
                if(is!=null){
                    is.close();
                }
                if(br!=null){
                    br.close();
                }



            } catch (IOException e2) {}
        }

        return sbRet;
    }
}
