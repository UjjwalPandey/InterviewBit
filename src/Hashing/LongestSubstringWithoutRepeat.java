/*
    Given a string, find the length of the longest substring without repeating characters.

    Example: The longest substring without repeating letters for "abcabcbb" is "abc", which the length is 3.
    For "bbbbb" the longest substring is "b", with the length of 1.
 */
package Hashing;

import java.util.HashMap;

public class LongestSubstringWithoutRepeat {
    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abcabcbb"));
        System.out.println(lengthOfLongestSubstring("bbbbbb"));
        System.out.println(lengthOfLongestSubstring("XLeHkNTaMYvHFMnDpuOesITCZIgNEnSHAlZldREYQKX7i2KeFPalYQZLCZHZNt13wSX7xf8Y6nJqj6LRszbdIQbDARZJrGCs5HDBTAP71nkl1qJiBXhU0r666cr89tCaaTH43tsL2T99VQIjve41ACEnXGsTFGBMAGOOvB1UkWuMRZy5B3YheXpdI2MQGIwWpSaHHTarTLeyK8FgExbOMoKNkIg2ba5B4BOUzk3GVBHE6wddQDh0hYXdIjiHxWFx18xUyqwpIebyLIUGVeMwxMXBICtnA7u9QofxnhKM9PU1qZOQweNwFKRxt1h7HaMPKKmdlgVyZ8QNzW72SvMwLAwRACsbiYsQDpgMPOcmMJhT6z6zndnL81AIqrXYsRBf7iu6eHkfs65sva5cfzDxp0083OVc7iFPWtMCJlTjt4lx8flLX88xQIcFcHVOfmk7gNzrp4mYgIbDMIxWbWvScAZn4QJKLISY5vaT5kHxQQXZz9BbNNtI9ovfIja9JGU44UOEMvvASkT2zMcU6F3ktouMMz68pjkRUXMTf90eOXwd8woWzeERGW1ugSBcgid3Vz2BxRooww0T2HPHbaBSG6im4MBKmjPm81rk03XCb35qGAfjZSd01prEVMJnhR9YkKXkQcv4QJkzoJ8DxMumP5asljL3p9Ft008MeACRhmzGasRYZLKcKuwQBl64dCKFq8ogbXdFrxv1WRUU6BlniXZYIC16BTYqmZWRXPEX5Wd9ybnxphrQWbatuJmZWgGTSCa61unGV7sfWmJgMnlbGOrJXQoipvjQJQlsMapSS7EteMPz9NdgcNOqbPlqkA8Kaa6uGgi86bUW2IgUAR7FTbojHrCzHRcmHJkP6JU6eAE22qg3SlxHnWZJRlkC32K4lwZknzHFVSV5UnmXC4nbQknsuOIiGi3hgO7IBylO5tPHMGUzjaXS2LHIqrABv5AEUTbnoV9lulOdZBv0kdqWcKyszX5iq3AAZ6RNSqNQBmOqEPbUAVr2O0Pkjbei43Lr6OoZmisq3L1f3h3xq4zYucLaohzwAmvIaaadEzgJVlp4RsTHXDMILAvKgHBNoiwmwIglL9qfNJv2NzMT10iLB5bR6bhdinOiafrRH7XpFZFvfRP0TbLY0iGrNeMUxNOU9Efdts1iEiNBj3qMUNsmmlYADzkiRFtc7ThbAzfA59f78m0XRZc4ifSFtr2wCG3fssPuF7xzbZPdnp8KeooYlnLzhUI6vax5qs6BbPtgIi3DvNhyVMfKG5hZzo26BVh0JU2ZpLTlHxESVruUU5DQuZKXzuLT34l9HeUiGgbVVn4EmIZUxAA9XZ8B8hHomDNbHq3kMOgmbmrYqwotApW8DYywUYJDDab1PntKWmY9TsuO9mmQz6xqTn8JVP9xyqsxAnNghI1HJyB7xSSj1Ziwpmt5TQOmJwDrLN88qDkkmoLPsdl6l3a0vcBPpuTk5yxdGJ7C1QfQL1FvEIPcfsxrkUxRxcTpo82I1YwtPkzmtrGkavm9HoNaaySsknM7OKup6Wc4Wbn7BUCe4fLm6LK"));
        System.out.println(lengthOfLongestSubstring("9iZuQU8KQ9nRUFip6G2RB4lIlGhmhTAYt5Mp9PopaJVWI2u9jPrOGnRZhQc98Jm7luwdvzpOkW8XymzFsj28aAP6JR1PpsWhD6ckUoM58ZCOyc1llSBw8T7p96fJDoEKRBOLhqFcVcEuKTkBnVPNoVFhiIfkUIjHRUOmg8fWSFbBRm2JZOB4QgFPPXvSYel5s03uC6HQbKmwxGtwy6XQpdB3qoq9QqdSVyepSZkV4T2tfZgI7GLI0vV2iC2Tb0TPirLa8DJ3tYwLosaaUbF24JxDl4HMWPOTEh3F5Yl25fi1qq4efHIdaCydNk5ldZetK7CXdF2TEmdlO1fRjfmvNdh9Lb03IXYrolbuvIXFb7KnVwCYkGMDMFRKQk9Izam49slzFaBZowDKeF35bnNjFIhLppn0RyPBvheulF0b00MBO8QQa0nOVc6v4OlAF5LQk3Tn0SEAs0wKaN4nBGSjfkR6Vtf7v84oEC2Q9UY6BXDI2g8YDDKL0eIdNATTfjuN15e57XRV0Cd5B5YNhECzTZ8qrFMyNiStd9bgyhNvG3uKwIOF6zl3DJoAxP6ebrdJ1LvsSCjFYmq6U2N4gSTTvtCJwNe4TN6QuPW7Ib59wP96HjgGdFHuxNuaZAvzNePeXuNK3WlRy8sSFXlxVPaUiLex24xbI9mA8B3T7RQJi1WA7cp6TpS4Ng54Bxdk6iPTrIAjZLyIHVv6mJYJ8gxzYyoXa1gPnHe4AotlR7fNljYSFCz2PWZQ2kfOO4TsBWq0eg0ZJYMP6Ac2HjMvKLO1WNsNn3HjFrHudMF6SL1VDnR2lXy3Bfkr8KtGN5WLFFXeubLdWohRqhMnm3eZldWo9oRt5hvtYtrjI23BNLPlxeNTMo4GqUunJaag7ufqw1gBcjMXpWbHfpMjHbV9r5lz7c0Zu2upBCQhxi3xZXqhjs3y5K7JeWnp744dcDRuRKHO040DLGLnSp3Xb38EZXAjFySPNFqyFxD2CERyikgAYh5nZCoxZ5knjyzLrABfLt8b12K93DeELrQkGCBXge38aXNcrVSEw5G67o4HDWpfVIiIxqmJV2rLvwMGvmyS65mp9eNoVy5r90fgUC705clZNatTNqt7umLTJvedo9OU9UsSiTN0SFu62riRBnXBEzF0qzbvFGCxpXWGKsYRbdw2tCza4mDUbbvu15t1AfzqvJde4PsXNAAwT02lQuccrmxQytes0xscpJvDuGBmfWPYe1I9tKrl92YRsgs2OVNp2CPBr5VvOBTeJzwk6m2H2ejuzA5orKOhEDZOPN5qiOWjkUN7FlHtL5CaGuE494QzzuYKVnR91NStWdLh3nIyuvUHR3rUaJmxiPzzNaG0EPtha1XuCJRlnrSaCkFNzN9eLHmJTBNYZbDyjZ7FnLcU2vEn1RcTpLFRzBv64RIUGzQ4M6wpSygm5iF4GWUd1eeR5u5QNxcOvGFojlTIYB9LbXGvVaBkLBexKv7kTgNrqbNiYTSIhGqsjY10mDygq"));
        System.out.println(lengthOfLongestSubstring("r5ZQiDf4NazTIVZTHRBTVK6vtJuppwoO3eqbIINSEa0pDboL11uhtcFVoMVz6P25aAX4QeCSBx159gIe5GUbbjsShE0NX5TSSHuevvDj3pbH158fBSo1saYDkJaWlaMilTyEmPIQwHjcFAUyQEG6fu50Ygz2BOz7bQaEbIN3A6x3NvtSGJo6Dun3TFk4Wa493pMyt0ecF7gmEF2GrCwrvkqYvl47ivkv9bRXH4x88YS2qVXyFLsWeF7UnCx4uG9nrpviU6zUoWdWB4WPPvlJH3HIJsZWpvi08GPddAhyZ2mbdwUCYhXWYpnEg7PoXoanJ4Ugd9Ay3LytuUffXnuU3mlt8X6dyd3ekhebgTrpM2m3lIFd3qJwJ4GT5AhsfQFFGTbDrOlFunJFNM4NXPJHps2E05NtvD3KXMkS205BarHv9MZ3wXvFHBqj1qFei0tLfIAP8BzQn0U7tTzoZndd7rOVa48oXWrRy4vzKE3y5qn301WVOfUuhMA2TFk2I1OqSRQiam6ZGsyjnESV0kAtXDViUgKoIlVQuYLsdQCoBq22N6EOssHrqwM95QqG8CtBixeKVqaj0BXnzBj1dCh7RsXaTu8QGSbU0qIOgOjHqEgOLxjeoeDgMyQJzOAc7T15UDSGu4s7285JhXJ8LUEwzwZ2BT7OO6nl4RuGmtJacQ2PyOZoPfcAPDgkHnNXHVGMEBmovaR2HD9qJfoPjpA7L3DTZ0fjFpw75DsBuJrWAFwC3w2za9Y8xKAxTCNdfefoR91U20hWz8D8hi6lOU8AC9YOKOsexyEEmQYwgNEsuIm5bbH5sLcfn7AFtk6Pjm4lUGkhmIQTAGM9iSGQpotL9QJEEW0VBAAdxrw5GfIceUp3GixQQ51JpCy77HMLrqdDq6mbHVjDfeSv9J2WdxVVCo8bn5mSZUy3ZbxwNoUPaNQSS2Ks6Z8msxL68G5XTzF7fNjPx4cNK66OsOBTRyC0ZR7v2pCPGcggxSHEM2ZgJmau4JAhMzCFvpWE5zehDt9PBXKNJDZCN2sXZ0suqToUuO2FMY57lQSZByOVzBaGdqSdCJpf0PDch8LVbr8N1jD69FGXPN024xFnq00WnNL7jDM38spQ1nvaX08GeI3qZyZp8Eb8ZUjbl2jC0b0vBOhhv5y2HGAeSjczQQxhC6ZQc8ZTM4sC6vx9uL2mBG77hqbfuF5lkPMp5e1mXjggooHSNfYbOa00F12Uzn3hwvlrtFet9BxXNqI22WSgVvqyj7xGrRJPY0u7hj"));
    }

    public static int lengthOfLongestSubstring(String A) {
        if(A.length() < 2){return A.length();}

        int i=0, j=0, maxl = 0;
        HashMap<Character,Boolean> table = new HashMap<>();
        while ( (i<A.length()) && (j<A.length()) ){
            boolean valJ = table.getOrDefault(A.charAt(j), false);
            // Value at J is FALSE
            if (!valJ){
                table.put(A.charAt(j),true);
                maxl = Math.max(maxl,j-i+1);
                j++;
            }else {  // When value at J is TRUE
                maxl = Math.max(maxl,j-i);
                table.put(A.charAt(i),false);
                i++;
            }
        }
        return maxl;
    }
}
