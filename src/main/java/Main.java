import com.insaniah.*;
import com.insaniah.programStructure.ProgramStructure;
import com.insaniah.result.*;
import core.Insaniah;
import core.InsaniahUrlConnection;
import org.apache.http.HttpEntity;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.util.PDFTextStripper;
import org.jsoup.nodes.Document;

import javax.xml.parsers.ParserConfigurationException;
import java.io.*;
import java.net.*;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

import static java.net.CookiePolicy.*;
import static java.net.CookiePolicy.ACCEPT_ALL;

public class Main {

    public static void main(String[] args) throws IOException, ParserConfigurationException {


//        Insaniah in = new Insaniah("a1012177", "kumite166");          //NURULLA
//        Insaniah in = new Insaniah("a1111231", "m204271");          //ME
//        Insaniah in = new Insaniah("a1210021", "jimtex88");           //FATAHI
//        Insaniah in = new Insaniah("a1011597", "Faruqm");             //FARUQ
//        Insaniah in = new Insaniah("a1320366","alade71");
//        Insaniah in = new Insaniah("a1111361", "1564119422529333");
//        in.login();
//        System.out.println("login status " + in.getLoggedInStatus());

//        System.out.println("from main "+in.getLoggedInStatus());


//        StudentInfo info = new StudentInfo(in);
//        System.out.println("Mystery name is " + info.getName());
//        System.out.println(info.getMatrix());
//        System.out.println(info.getProgramme());
//        System.out.println(info.getBalance());
//        System.out.println(info.getSemester());
//        System.out.println(info.getKulliyyah());
//        System.out.println(info.getStatus());
//        System.out.println(info.getPassport());
//        System.out.println(info.getBirthDay());

//
//        Taqwin t = new Taqwin(in);
//        System.out.println(t.getNumOfRow());
//        String[][] table = t.getTaqwinTable();
//
//        for (int i = 0; i < t.getNumOfRow(); i++) {
//            for (int j = 0; j < 3; j++) {
//                System.out.print(table[i][j] + "\t");
//            }
//            System.out.println();
//        }
//
//
//
//
//    System.out.println("helel");

//        Insaniah insaniah = new Insaniah("a1111231","m204271");
//        insaniah.login();
//
//        CloseableHttpClient client = insaniah.getClient();
//        org.jsoup.parser.Parser p = org.jsoup.parser.Parser.htmlParser();
//        HttpGet getMethod;
//        CloseableHttpResponse response;
//        String resString;
//        HttpEntity entity;
//        Document doc;
//
//        getMethod = new HttpGet("http://ecampus.insaniah.edu.my/portal/placement_result.php");
//        response = client.execute(getMethod);
//        entity = response.getEntity();
//        resString = EntityUtils.toString(entity);
//
//        doc = p.parseInput(resString,"");
//
//
//
//        System.out.println(doc.body().getElementsByTag("table").get(4).getElementsByTag("td").get(1).text());


//        PlacementTests pls = new PlacementTests(in);
//
//        for(int i=0;i<2;i++){
//            System.out.println("testNmae: " + pls.getPalcementTests()[i].getTestName());
//            System.out.println("band: " + pls.getPalcementTests()[i].getBand());
//            System.out.println("Result : "+pls.getPalcementTests()[i].getResult());
//        }


//        String[][] s = new String[2][];
//
//        s[0] = new String[4];
//        s[1] = new String[5];
//
//        System.out.print(s[0].length);
//        System.out.print(s[1].length);


//        ProgramStructure pro;
//
//        pro = new ProgramStructure(in);
//        for (int i = 0; i < pro.getNumOfSem(); i++) {
//            System.out.println("==============================================================================");
//            System.out.println("FOR SEM:" + i);
//            for (int j = 0; j < pro.getNumOfCoursesInSem(i); j++) {
//
//                System.out.print(pro.getCourses()[i][j].getCourseCode() + "\t");
//                System.out.print(pro.getCourses()[i][j].getCourseName() + "\t");
//                System.out.print(pro.getCourses()[i][j].getCreditHours() + "\t");
//                System.out.print(pro.getCourses()[i][j].getPreRequiste() + "\t");
//                System.out.print(pro.getCourses()[i][j].getOfferStatus() + "\t");
//                System.out.println("");
//            }
//        }


//        ConvocationStatus convo = new ConvocationStatus(in);
//        System.out.println("minimum credit "+convo.getMinimumCredit());
//        System.out.println("credit earned "+convo.getCreditEarned());
//        System.out.println("status is "+convo.getStatus());

////
//        File file = new File("/Users/LEO/Documents/result4.pdf");
//        PDDocument document = PDDocument.load(file);
//        PDFTextStripper stripper = new PDFTextStripper();
//        String text = stripper.getText(document);
//
//
//        System.out.println(text.toString());
//
//        Result result = new Result(text);
//        ResultCourse[] coures = result.getResultCourses();
//
//
//        for (int i = 0; i < coures.length; i++) {
//            System.out.print(coures[i].getCourseCode() + "\t");
//            System.out.print(coures[i].getCourseName() + "\t");
//            System.out.print(coures[i].getCreditHour() + "\t");
//            System.out.print(coures[i].getGrade() + "\t");
//            System.out.println("");
//        }
//
//        System.out.println("for gpa toatl credithour is " + result.getGpaCreditHour() + ", totalGrade point is " + result.getGpaTotalGrade() + " and  gpa is " + result.getGpaAvgGrade());
//
//        System.out.println("For cgpa, total credit hour is " + result.getCgpaCreditHour() + ", totalGrade is " + result.getCgpaTotalGrade() + " and cgpa is " + result.getCgpaAvgGrade());

//

//        CloseableHttpClient client  = in.getClient();
//        CloseableHttpResponse response;
//        HttpPost post = new HttpPost("http://ecampus.insaniah.edu.my/portal/result_exam.php");
//        List<BasicNameValuePair> params = new ArrayList<BasicNameValuePair>();
//        params.add(new BasicNameValuePair("fail_jana", "VlZaU1JtVkZNVlZTV0d4T1pXdGFiVlJzVFRCa01IaDFVVzEwWVZwNk1Eaz0="));
//        params.add(new BasicNameValuePair("result", "DOWNLOAD"));
//        post.setEntity(new UrlEncodedFormEntity(params));
//        response = client.execute(post);
//
//
//        HttpEntity entity = response.getEntity();
//        String resString = EntityUtils.toString(entity, "UTF-8");


//        System.out.println(resString);


//        BufferedInputStream bis = new BufferedInputStream(entity.getContent());
//        String filePath = "Desktop";
//        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(new File(filePath)));
//        int inByte;
//        while((inByte = bis.read()) != -1) bos.write(inByte);
//        bis.close();
//        bos.close();
//
//        System.out.println("result saved successfully");


//        File file = new File("/Users/LEO/Documents/result01.pdf");
//        File file = new File("result01.pdf");
//        PDDocument document = PDDocument.load(file);
//        PDFTextStripper stripper = new PDFTextStripper();
//        String text = stripper.getText(document);


//        System.out.println(entity.toString());


//        String s1 = "VlZaU1JtVkZNVlZTV0d4T1pXdGFiVlJzVFRCa01IaDFVVzEwWVZwNk1Eaz0=";
//        String s2 = "VlZaU1JtVkZNVlZTV0d4T1pXdGFiVlJzVFRCa01IaDFVVzEwWVZwNk1Eaz0=";
//        if(s1.equals(s2)){
//            System.out.println("They are just exactly the same");
//        }


//        CloseableHttpClient client = HttpClients.createDefault();
//        HttpPost post = new HttpPost(URLConstants.BASE_URL);
//        List<BasicNameValuePair> params = new ArrayList<BasicNameValuePair>();
//        params.add(new BasicNameValuePair("txtMatric", "a1210021"));
//        params.add(new BasicNameValuePair("txtPwd", "jimtex88"));
//        params.add(new BasicNameValuePair("btnLogin", "Login"));
//        post.setEntity(new UrlEncodedFormEntity(params));
//        client.execute(post);
//
//
//
//
//        CloseableHttpResponse response;
//        post = new HttpPost("http://ecampus.insaniah.edu.my/portal/result_exam.php");
//        List<BasicNameValuePair> params1 = new ArrayList<BasicNameValuePair>();
//        params1.add(new BasicNameValuePair("fail_jana", "VlZaU1JtVlZNVlZSV0dST1lXdGFiVlJZYXpCa01IaDFVVzEwWVZwNk1Eaz0="));
//        params1.add(new BasicNameValuePair("result", "DOWNLOAD"));
//        post.setEntity(new UrlEncodedFormEntity(params1));
//        response = client.execute(post);
//
//
//        HttpEntity entity = response.getEntity();
////        String resString = EntityUtils.toString(entity, "UTF-8");
//
//
//
////        System.out.println(resString);
//
//
//        BufferedInputStream bis = new BufferedInputStream(entity.getContent());
//        String filePath = "Desktop";
//        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(new File(filePath)));
//        int inByte;
//        while((inByte = bis.read()) != -1) bos.write(inByte);
//        bis.close();
//        bos.close();
//
//
//        System.out.println("successfully saved");


//        ResultDownloader rd = new ResultDownloader(in);


//        Document doc = in.getDoc(URLConstants.RESULT_DOWNLOAD);
//
//        int numOfSem = doc.body().getElementsByTag("table").get(1).child(2).getElementsByTag("tr").size();
//        System.out.println("you have done "+numOfSem+" semester");
//
//        //1 , 2 and 4 fix   change 3 to get every semester
//        String checkGpa = doc.body().getElementsByTag("table").get(1).child(2).getElementsByTag("tr").get(5).child(1).text();
//        System.out.println(checkGpa);
//
//        //1,2,4 and 5 fix       change 3 to get every semester
//        String value =  doc.body().getElementsByTag("table").get(1).child(2).getElementsByTag("tr").get(5).child(3).child(0).attr("value");
//        System.out.println(value);

//        Insaniah insaniah = new Insaniah("a1111276", "zubair");
//        insaniah.login();
//
//        ResultDownloader downloader = new ResultDownloader(insaniah);
//        downloader.downloadFiles();


//        CloseableHttpClient client = HttpClients.createDefault();
//        HttpPost post = new HttpPost("http://ecampus.insaniah.edu.my/portal/login.php");
//        List<BasicNameValuePair> params = new ArrayList<BasicNameValuePair>();
//        params.add(new BasicNameValuePair("txtMatric", "a1111231"));
//        params.add(new BasicNameValuePair("txtPwd", "m204271"));
//        params.add(new BasicNameValuePair("btnLogin", "Login"));
//        post.setEntity(new UrlEncodedFormEntity(params));
//        CloseableHttpResponse response  = client.execute(post);
//
//        HttpEntity entity = response.getEntity();
//        String resString = EntityUtils.toString(entity, "UTF-8");

//        System.out.println(resString);

//


//        Insaniah insaniah = new Insaniah("a1210933","olasunkanmi20000");
//        insaniah.login();
//
//
//        ResultDownloader downloader = new ResultDownloader(insaniah);
//
//        downloader.downloadFiles();

//        InsaniahUrlConnection insaniahUrlConnection = new InsaniahUrlConnection("a1111231","m204271");
//        insaniahUrlConnection.login();
//
//
//        ResultDownloaderForUrlConnection resultDownloaderForUrlConnection = new ResultDownloaderForUrlConnection(insaniahUrlConnection);
//
//
//        System.out.print(resultDownloaderForUrlConnection.getNumOfSem());


        ResultParser parser = new ResultParser("result1.pdf");

        Result result = new Result(parser.parseToString(),false);


        ResultCourse[] courses = result.getResultCourses();


        for(int i=0;i<courses.length;i++){
            System.out.print(courses[i].getCourseCode()+"");
            System.out.print(courses[i].getCourseName()+"");
            System.out.println(courses[i].getGrade());
            System.out.println();
        }


//        System.out.println(parser.parseToString());


    }

}