package com.company;

public class Main {

    public static void main(String[] args) {
        try {
            String url = "//www.jb51.net/";
            java.net.URI uri = java.net.URI.create(url);             // 獲取當前系統桌面擴充套件
            java.awt.Desktop dp = java.awt.Desktop.getDesktop();    // 判斷系統桌面是否支援要執行的功能
            if (dp.isSupported(java.awt.Desktop.Action.BROWSE)) {
                dp.browse(uri);                       //獲取系統預設瀏覽器開啟連結
            }
        } catch (java.lang.NullPointerException e) {   //當網址為空時
            e.printStackTrace();
        } catch (java.io.IOException e) {             //無法獲取系統預設瀏覽器
            e.printStackTrace();
        }
    }
}
