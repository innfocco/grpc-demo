package grpc;

import java.util.*;

public class RandomName {
    public static class FirstName{
        public static String next(){
            List<String> values = Arrays.asList(
                   "Maria","Ana","Francisca","Antonia","Juliana",
                   "Marcia","Fernanda","Patricia","Aline","Helena",
                   "Alice","Laura","Manuela","Valentina","Sophia",
                   "Isabella","Heloisa");
            int min = 0;
            int max = values.size()-1;
            int randomIndex = (int)(Math.random()*(max-min+1)+min);
            return values.get(randomIndex);
        }
    }

    public static class LastName{
        public static String next(){
            List<String> values = Arrays.asList(
                   "Smith","Johnson","Williams","Brown","Jones",
                   "Garcia","Miller","Davis","Rodriguez","Martinez",
                   "Hernandez","Lopez","Gonzalez","Wilson","Anderson",
                   "Thomas","Taylor","Moore","Jackson","Martin");
            int min = 0;
            int max = values.size()-1;
            int randomIndex = (int)(Math.random()*(max-min+1)+min);
            return values.get(randomIndex);
        }
    }

    public static class Age{
        public static int next(){
            int min = 10;
            int max = 80;
            return (int)(Math.random()*(max-min+1)+min);
        }
    }
}
