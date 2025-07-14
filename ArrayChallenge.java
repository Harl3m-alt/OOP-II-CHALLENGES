package challenges;

public class ArrayChallenge {
    public static void main(String[] args) {
        String[]orderIds = {"B123","C234","A245","C15","B177","C235","B179","C235","B765","V456","T467",};

        for(String item: orderIds){
            if(item.startsWith("B")){
                System.out.println(item);
            }
        }
    }
}
