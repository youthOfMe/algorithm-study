package com.yang.dachang.timet24t10.time19;

import java.util.Random;

/**
 * 随机生成名字的工具类
 */
public class Util {

    // 封装的随机生成名字的工具类
    public static class RandomNameUtil {
        String familyName1 = "赵钱孙李周吴郑王冯陈褚卫蒋沈韩杨朱秦尤许何吕施张孔曹严华金魏陶姜戚谢邹喻水云苏潘葛奚范彭郎鲁韦昌马苗凤花方俞任袁柳鲍史唐费岑薛雷贺倪汤滕殷罗毕郝邬安常乐于时傅卞齐康伍余元卜顾孟平";
        String familyName2 = "欧阳太史端木上官司马东方独孤南宫万俟闻人夏侯诸葛尉迟公羊赫连澹台皇甫宗政濮阳公冶太叔申屠公孙慕容仲孙钟离长孙宇文司徒鲜于司空闾丘子车亓官司寇巫马公西颛孙壤驷公良漆雕乐正宰父谷梁拓跋夹谷轩辕令狐段干百里呼延东郭南门羊舌微生公户公玉公仪梁丘公仲公上公门公山公坚左丘公伯西门公祖第五公乘贯丘公皙南荣东里东宫仲长子书子桑即墨达奚褚师吴铭";
        String girlName = "秀娟英华慧巧美娜静淑惠珠翠雅芝玉萍红娥玲芬芳燕彩春菊兰凤洁梅琳素云莲真环雪荣爱妹霞香月莺媛艳瑞凡佳嘉琼勤珍贞莉桂娣叶璧璐娅琦晶妍茜秋珊莎锦黛青倩婷姣婉娴瑾颖露瑶怡婵雁蓓纨仪荷丹蓉眉君琴蕊薇菁梦岚苑婕馨瑗琰韵融园艺咏卿聪澜纯毓悦昭冰爽琬茗羽希宁欣飘育滢馥筠柔竹霭凝晓欢霄枫芸菲寒伊亚宜可姬舒影荔枝思丽";
        String boyName = "伟刚勇毅俊峰强军平保东文辉力明永健世广志义兴良海山仁波宁贵福生龙元全国胜学祥才发武新利清飞彬富顺信子杰涛昌成康星光天达安岩中茂进林有坚和彪博诚先敬震振壮会思群豪心邦承乐绍功松善厚庆磊民友裕河哲江超浩亮政谦亨奇固之轮翰朗伯宏言若鸣朋斌梁栋维启克伦翔旭鹏泽晨辰士以建家致树炎德行时泰盛雄琛钧冠策腾楠榕风航弘";

        public String getFamilyName() {
            String str = "";
            int randNum = new Random().nextInt(2) + 1;
            int strLen = randNum == 1 ? familyName1.length() : familyName2.length();
            int index = new Random().nextInt(strLen);
            if (randNum == 1) {
                str = String.valueOf(familyName1.charAt(index));
            } else {
                str = (index & 1) == 0 ? familyName2.substring(index, index + 2) : familyName2.substring(index - 1, index + 1);
            }
            return str;
        }

        public String getSex() {
            int randNum = new Random().nextInt(2) + 1;
            return randNum == 1 ? "男" : "女";
        }

        public String[] getNameAndSex(String sex) {
            String[] nameSex = new String[2];
            int randNum = new Random().nextInt(2) + 1;
            int strLen = sex.equals("男") ? boyName.length() : girlName.length();
            int index = (randNum & 1) == 0 ? new Random().nextInt(strLen - 1) : new Random().nextInt(strLen);
            nameSex[0] = sex.equals("男") ? boyName.substring(index, index + randNum) : girlName.substring(index, index + randNum);
            nameSex[1] = sex.equals("男") ? "男" : "女";
            return nameSex;
        }

        public int getAge() {
            return new Random().nextInt(4) + 18;
        }

        public String getInfo() {
            int sexNum = (int) (Math.random() * 2);
            String familyName = getFamilyName();
            String[] nameAndSex = getNameAndSex(sexNum == 1 ? "男" : "女");
            return familyName + nameAndSex[0] + " , 性别: " + nameAndSex[1];
        }
    }

}
