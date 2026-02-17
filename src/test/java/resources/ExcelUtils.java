package resources;// প্রয়োজনীয় Apache POI লাইব্রেরি ইম্পোর্ট করা হয়েছে
import org.apache.poi.ss.usermodel.*;          // Sheet, Row, Cell, Workbook ইত্যাদি ক্লাস
import java.io.FileInputStream;               // ফাইল থেকে ডেটা পড়ার জন্য
import java.io.IOException;                   // ফাইল না পাওয়া গেলে exception হ্যান্ডেল করতে
import java.util.ArrayList;                   // এখানে ব্যবহার হয়নি (অপ্রয়োজনীয় ইম্পোর্ট)
import java.util.List;                        // এটাও এখানে ব্যবহার হয়নি

public class ExcelUtils {

    /**
     * এই মেথড Excel ফাইল থেকে ডেটা পড়ে 2D array তে রিটার্ন করে
     * @param filePath   Excel ফাইলের পুরো পাথ (যেমন: "test_data.xlsx")
     * @param sheetName  কোন শীট থেকে ডেটা পড়তে চাও (যেমন: "Sheet1")
     * @return Object[][] → টেস্ট ক্লাসে @DataProvider-এর জন্য ব্যবহার করা যায়
     * @throws IOException ফাইল না পেলে বা পড়তে সমস্যা হলে
     */
    public static Object[][] getData(String filePath, String sheetName) throws IOException {

        // ফাইল ওপেন করা (FileInputStream দিয়ে)
        FileInputStream fis = new FileInputStream(filePath);

        // Apache POI দিয়ে Excel ওয়ার্কবুক তৈরি (.xlsx ফরম্যাট সাপোর্ট করে)
        Workbook workbook = WorkbookFactory.create(fis);

        // নির্দিষ্ট শীট সিলেক্ট করা
        Sheet sheet = workbook.getSheet(sheetName);

        // শীটে কতগুলো row আছে (0-based index) → last row number
        // উদাহরণ: ৫টা row থাকলে getLastRowNum() = 4 (header সহ)
        int rowCount = sheet.getLastRowNum();           // rows - 1 (header skip করার জন্য)

        // প্রথম row-এ কতগুলো column আছে তা বের করা
        int colCount = sheet.getRow(0).getLastCellNum();  // column count (1-based)

        // 2D array তৈরি করা → rowCount × colCount সাইজের
        // ডেটা শুধু header ছাড়া রাখা হবে
        Object[][] data = new Object[rowCount][colCount];

        // লুপ: row 1 থেকে শুরু (header skip করা হয়েছে)
        for (int i = 1; i <= rowCount; i++) {

            Row row = sheet.getRow(i);   // বর্তমান row নেওয়া

            // প্রত্যেক column-এর জন্য লুপ
            for (int j = 0; j < colCount; j++) {

                Cell cell = row.getCell(j);  // বর্তমান cell নেওয়া

                // cell খালি থাকলে "" রাখা, না হলে value ট্রিম করে String-এ কনভার্ট
                data[i-1][j] = (cell == null) ? "" : cell.toString().trim();
            }
        }

        // রিসোর্স ক্লোজ করা (memory leak এড়ানোর জন্য ভালো প্র্যাকটিস)
        workbook.close();
        fis.close();

        // 2D array রিটার্ন করা → TestNG DataProvider-এ সরাসরি ব্যবহার করা যাবে
        return data;
    }
}