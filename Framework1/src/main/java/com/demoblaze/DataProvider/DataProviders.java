package com.demoblaze.DataProvider;

import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.DataProvider;

import com.demoblaze.Utilities.NewExcelLibrary;

public class DataProviders {

    // Initialize the NewExcelLibrary with path to your Excel file
    NewExcelLibrary obj = new NewExcelLibrary("C:\\Users\\USER\\Desktop\\Training\\Final repo\\Framework1\\src\\resource\\java\\testData\\testdata.xlsx");

    @DataProvider(name = "credentials")
    public Object[][] getCredentials() {
        int rows = obj.getRowCount("Credentials");
        int column = obj.getColumnCount("Credentials");
        int actRows = rows - 1;

        Object[][] data = new Object[actRows][column];

        for (int i = 0; i < actRows; i++) {
            for (int j = 0; j < column; j++) {
                data[i][j] = obj.getCellData("Credentials", j, i + 2);
            }
        }
        return data;
    }
    
    @DataProvider(name = "regDetails")
    public Object[][] getRegDetails() {
        int rows = obj.getRowCount("RegDetails");
        int column = obj.getColumnCount("RegDetails");
        int actRows = rows - 1;

        Object[][] data = new Object[actRows][column];

        for (int i = 0; i < actRows; i++) {
            for (int j = 0; j < column; j++) {
                data[i][j] = obj.getCellData("RegDetails", j, i + 2);
            }
        }
        return data;
    }
    
    @DataProvider(name = "email")
    public Object[][] getEmail() {
        int rows = obj.getRowCount("Email");
        int column = obj.getColumnCount("Email");
        int actRows = rows - 1;

        Object[][] data = new Object[actRows][column];

        for (int i = 0; i < actRows; i++) {
            for (int j = 0; j < column; j++) {
                data[i][j] = obj.getCellData("Email", j, i + 2);
            }
        }
        return data;
    }

    @DataProvider(name = "getProduct")
    public Object[][] getProduct() {
        int rows = obj.getRowCount("ProductDetails");
        int column = obj.getColumnCount("ProductDetails");
        int actRows = rows - 1;

        Object[][] data = new Object[actRows][column];

        for (int i = 0; i < actRows; i++) {
            for (int j = 0; j < column; j++) {
                data[i][j] = obj.getCellData("ProductDetails", j, i + 2);
            }
        }
        return data;
    }

    @DataProvider(name = "searchProduct")
    public Object[][] getProductPrice() {
        int rows = obj.getRowCount("SearchProduct");
        int column = obj.getColumnCount("SearchProduct");
        int actRows = rows - 1;

        Object[][] data = new Object[actRows][column];

        for (int i = 0; i < actRows; i++) {
            for (int j = 0; j < column; j++) {
                data[i][j] = obj.getCellData("SearchProduct", j, i + 2);
            }
        }
        return data;
    }

    @DataProvider(name = "newAcountDetailsData")
    public Object[][] accountCreation() {
        int rows = obj.getRowCount("AccountCreationData");
        int column = obj.getColumnCount("AccountCreationData");
        int actRows = rows - 1;

        Object[][] data = new Object[actRows][1];

        for (int i = 0; i < actRows; i++) {
            Map<String, String> hashMap = new HashMap<>();
            for (int j = 0; j < column; j++) {
                hashMap.put(obj.getCellData("AccountCreationData", j, 1),
                        obj.getCellData("AccountCreationData", j, i + 2));
            }
            data[i][0] = hashMap;
        }
        return data;
    }

}
