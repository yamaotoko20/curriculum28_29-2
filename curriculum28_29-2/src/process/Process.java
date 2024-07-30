package process;

import java.util.Arrays;
import java.util.Collections;

public class Process {
    private final String[] prefectures = {
        "北海道:札幌市:83424",
        "青森県:青森市:9646",
        "岩手県:盛岡市:15275",
        "宮城県:仙台市:7282",
        "秋田県:秋田市:11638",
        "山形県:山形市:9323",
        "福島県:福島市:13784",
        "茨城県:水戸市:6097",
        "栃木県:宇都宮市:6408",
        "群馬県:前橋市:6362",
        "埼玉県:さいたま市:3798"
    };

    public void processPrefectures(String input) {
        if (input != null && !input.isEmpty()) {
            String[] inputArray = input.split(",");
            String order = inputArray[inputArray.length - 1];

            if (order.equalsIgnoreCase("asc")) {
                Arrays.sort(inputArray, 0, inputArray.length - 1);
            } else if (order.equalsIgnoreCase("desc")) {
                Arrays.sort(inputArray, 0, inputArray.length - 1, Collections.reverseOrder());
            }

            for (String index : inputArray) {
                try {
                    int i = Integer.parseInt(index);
                    if (i >= 0 && i < prefectures.length) {
                        String prefectureInfo = prefectures[i];
                        String[] details = prefectureInfo.split(":");
                        if (details.length == 3) {
                            String prefectureName = details[0];
                            String capitalCity = details[1];
                            double area = Double.parseDouble(details[2]);

                            System.out.println("都道府県名：" + prefectureName);
                            System.out.println("県庁所在地：" + capitalCity);
                            System.out.println("面積：" + area + "km2");
                        } else {
                            System.out.println("都道府県情報のフォーマットが正しくありません");
                        }
                    } else {
                        System.out.println("該当する都道府県情報が見つかりませんでした");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("入力が数字ではありません");
                }
            }
        } else {
            System.out.println("入力が空です");
        }
    }
}