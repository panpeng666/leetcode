package leetcode;

import java.util.HashMap;

/**
 * 您将获得一个字符串数组  words 和一个字符串  chars。
 *
 * 字符串是好的，  如果它可以由字符组成chars （每个字符只能使用一次）。
 *
 * 例1：
 *
 * 输入： words = [“cat”，“bt”，“hat”，“tree”]，chars = “atach”
 * 输出：6
 * 说明：
 * 可以形成的字符串是“cat”和“hat”，所以答案是3 + 3 = 6。
 * 例2：
 *
 * 输入： words = [“hello”，“world”，“leetcode”]，chars = “
 * welldonehoneyr ” 输出：10
 * 说明：
 * 可以形成的字符串是“hello”和“world”所以答案是5 + 5 = 10。
 *
 *
 * 注意：
 *
 * 1 <= words.length <= 1000
 * 1 <= words[i].length, chars.length <= 100
 * 所有字符串仅包含小写英文字母。
 */


//这道题有用hashMap解题的方法，但是没看懂
public class java1160 {
       static class Solution {
        public int countCharacters(String[] words, String chars) {
            StringBuilder result = new StringBuilder();
            if (words.length==0||chars.length()==0){
                return 0;
            }else {

            for (int i=0;i<words.length;i++){
                if (words[i].length()>=chars.length()){
                    break;
                }
                int count=0;
                String temp =chars;
                for (int j=0;j<words[i].length();j++){

  //                  System.out.println("第"+i+"组数据的第"+j+"个字符"+words[i].charAt(j));
                    if (temp.contains(String.valueOf(words[i].charAt(j)))){
//                        System.out.println("第"+i+"组的第"+j+"个字符 包含在chars里");
                        count++;
                        temp.replace(String.valueOf(words[i].charAt(j)),"");
                    }
                }
                if (count==words[i].length()){
                    result.append(words[i]);
                    System.out.println(words[i]+" -----pipei");
                }
            }

            return result.length();
        }
        }
           public int countCharacters1(String[] words, String chars) {
               int count = 0;
               for (int i = 0; i < words.length; i++) {
                   String word = words[i];
                   int tempCount = 0;
                   String tempChars = chars;
                   for (int j = 0; j < word.length(); j++) {
                       String temp = String.valueOf(word.charAt(j));
                       if (tempChars.contains(temp)) {
                           tempCount++;
                           tempChars = tempChars.replaceFirst(temp, "");
                       } else {
                           tempCount = 0;
                           break;
                       }
                   }
                   count += tempCount;
               }
               return count;

           }
//hashMap
           public int countCharacters2(String[] words, String chars)
           {
               if(words.length==0||chars.length()==0)return 0;
               //如果字符串或数组为空，直接反回0
               char[] ch=chars.toCharArray();
               //字符串拆分成数组
               HashMap<Character,Integer> map=new HashMap<>();
               //创建一个hashMap
               int ans=0;
               //定义返回值
               for(char c:ch)
               {
                   map.put(c,map.getOrDefault(c,0)+1);
               }
               int len=words.length;
               for(int i=0;i<=len-1;i++)
               {
                   boolean flag=false;
                   char[] cc=words[i].toCharArray();
                   HashMap<Character,Integer> temp=(HashMap)map.clone();
                   for(int j=0;j<=cc.length-1;j++)
                   {
                       if(!map.containsKey(cc[j])){flag=true;break;}//no such,break
                       else
                       {
                           if(temp.get(cc[j])>=1)temp.put(cc[j],temp.get(cc[j])-1);//enough,then -1
                           else {flag=true;break;}//not enough,break
                       }
                   }
                   if(flag)continue;
                   ans+=words[i].length();
               }
               return ans;
           }
       }






  public   static void main(String[] args){
        Solution solution=new Solution();
        String[] x={"pxlqovnbsgvqjzpfeidchzrodnbqfrccfydzjptukscjuatlsrcurepllxzyghhdepitqptlmfkhzxjgswaulxkfydhkilg","uqklvqnlhdkwryjawkqfajfpbcnhglxlwxlaskxlytr","jvgkxcdkxrvfahjkvhmfuyjzxtyxrsogbtsjybeaxugqymcr","rgxditmosplnqvodtis","jm","ruqjwejuanjtiizcmbieobesnjnadzqvqumggblzmkxilgfarnxwpcawtkzxlvugibpidvwtikloeziuxqoi","wxeyzrnbhlhwxecrgejsrawyulynvgtszwqqlihkcvckgcgtgpyqtkuwvjywmhpskaiwmpyarftqhnogxpith","vdpbykqlihtpvfnqbrcjpggojqbalerohyitktuikbffvfatcnneuvbanjihiaorrjcdthntnrxebfhvshmpodmzhtwnasbm","wgjstkoaojcesfdrllugmojwdmgeejyiqvshlowtktddattunarnohgvqsoskfmbrami","ecwqxbawirvnxvsjybbebclaturorlcbpf","gtjbaigvufrotlwfoqqolnjabnvtbcygtfcytinzpcjbvprdkdjawrcbthmxjrabimhhs","cvzlbrvppkyxtjxzeglzwoagmpjnfxddbwolxmwdohgtfktgftzzkwpianslkpldyfzubtjczse","neaw","mxhmvkajofnmdiiduactlemcvpztscmsnrdhuhquxnnzywsrzxyplgbppiypxwcfbsnyzblaeifo","krekecabfpufucjhqphjnibaeqdvdpmrfougdwugvoioqangdnxromwlxnfeydaneyazzclscqgdxlhhgnoqmslfflzqv","klutvchxsceihfmzitgqakytesfjykribjhjzdruuoycjkwaghmmqkfrhkrtawudtjyjwqbyspamlegqjlwlj","raykfkflqdzrpthdejetwolgciygwaktulkxemkdbbllkjxhnnafsms","os","xhchkcetmlprcdmrnalvkvgabxxnomphqpqhnddqhecogspbdebeoshvjgzvmqu","jqtdysnpskktynxwmsfaabglagnqcllptvuyyqjwrmqaftenusmsahhhqubkwxltpr","sulmwluiwvlroldpiyecaicwrawzwflokefqkdwmxejaovvpbflfdtviinbvvtlhhhefmgfsqs","sxyhcckvyl","vsaacsybcddxvuzkddjmuivsvtjyanpbydmkcwnkmxvsiantgkvkmqjysclsvd","sxcghypulvmfqfunxj","pozekufhlooosxpcggbi","xzaoxzllcixfqbupqozmzrnugj","j","tgslwp","ntrdkixexajlpjgmcbrqimwtqnzfrqjszeiuvrgzclerzmsnagzaxbredvlrmipzflrzusclckmxphc","ifdflsywdfizpodsehrrifsvejcxarrxmxyjgbbvqyqvywncphzfmnxhybxpdcozfnzablfx","uluhplzrsaehaqxfnbcmixueedevhirbwqdyztwaxnkogcauymxgcpabxekib","agtfkinbdccoemxetbryzpluzlpyzicnfopphrxriqm","pdympxpwvxwcqaxrvbvyqkrresrjgzgxuyfxtkgldtathokdbyfsqfmitmiyagtqgijaiazvsumeyutbbwxqdshquzrehn","rqe","sljsvenhhstnnngzqyo","dezrzpgldeimxfoqajuhjctgvalwkhkjemjaxumxqmifglbizusuqlttxirpbqbuvauwy","dkwpyezbmkcskoxxcgrxcewknqgdckjxfyzcmzqcbyeucxbqybxoldogtkmdknsrruvnlfqnpfx","sjeftmjkuperfynbreycwhuoyqybticswblbrrpugzhlrmiedjqufnehevzqwtaebwvdswsz","lolnfyliloqmhjmhhohdtgfajjfdjqpubslbsrwitbjmrcegdrdjzvonxaefdvdfcbqmaaks","qhcoaiocjhuzywkirlblajgeapzajqsoa","sxrmoqxqbtakuqwmrrkljmegbwbeqbywmlyuprwyhljzejbybxoumidpxdrohwdjoqycpxcmivaulnqzneydwqfsvcxgyyseuk","yrowy","dohrzkrzdjehpctnjrvhzojullsiucrhphshwxwicyzkvzbqrztic","rmshnxtbhsdgkiijrmwulocdzjzpgfyimkjdthuzkhoqgkeawgwincubrloknocxwzgqqcxafksxgzh","aymovnuhptozhkiyowbeguzlkmrwjnujgjbdne","abc","vxoigovwmqizmkwbkktqk","uokwktdempzloaglvvkqstztmwzcmhgxtoua","bzwjxqueazlzfojrkbqmhtwrvuwsnfcnylurnddpektekca","qgndjgvzcyajhgmrrnhdywwdbmkhtthwcfiueuxfldanyrmccwcy"};
        System.out.println(solution.countCharacters(x,"figspbov"));
    }
}
