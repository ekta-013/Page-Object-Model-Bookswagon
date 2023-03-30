package com.bridgelabz.utility;

public class DataProvider {
    @org.testng.annotations.DataProvider(name = "testLoginData")
    public  Object[][] getDataFromSheetFile()  {
        DataDrivenFramework ddf = new DataDrivenFramework("C:\\Users\\EKTA\\IdeaProjects\\PageObjectBooksWagon\\src\\main\\resources\\Data.xlsx");
        int rows = ddf.getRowCount(0);
        Object[][] dataForLogin = new Object[rows][2];
        for(int i = 0; i < rows; ++i) {
            for(int j = 0; j < 2; j++) {
                dataForLogin[i][0] = ddf.getData(0,i,0);
                dataForLogin[i][1] = ddf.getData(0,i,1);
            }
        }
        return dataForLogin;
    }
}
