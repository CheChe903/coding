class Solution {
    public String solution(int[] numbers, String hand) {
        String answer = "";
        
        int leftX = 4;
        int leftY = 1;
        int rightX = 4;
        int rightY = 3;
        
        StringBuilder sb = new StringBuilder();
        
        for(int number: numbers) {
            if(number == 1 || number == 4 || number == 7) {
                if(number == 1) {
                    leftX = 1;
                    leftY =1;
                }
                else if(number == 4) {
                    leftX = 2;
                    leftY = 1;
                }
                else {
                    leftX = 3;
                    leftY = 1;
                }
                sb.append("L");
            }
            else if(number == 3 || number == 6 || number ==9) {
                if(number == 3) {
                    rightX = 1;
                    rightY = 3;
                }
                else if(number == 6) {
                    rightX = 2;
                    rightY = 3;
                }
                else {
                    rightX = 3;
                    rightY = 3;
                }
                sb.append("R");
            }
            else {
                if(number == 2) {
                    int leftDistance = Math.abs(leftX - 1) + Math.abs(leftY -2);
                    int rightDistance = Math.abs(rightX - 1) + Math.abs(rightY -2);
                    if(leftDistance > rightDistance) {
                        rightX = 1;
                        rightY = 2;
                        sb.append("R");
                    }
                    else if(leftDistance < rightDistance){
                        leftX= 1;
                        leftY = 2;
                        sb.append("L");
                    }
                    else {
                        if(hand.equals("right")) {
                            rightX = 1;
                            rightY = 2;
                            sb.append("R");
                        }
                        else {
                            leftX= 1;
                            leftY = 2;
                            sb.append("L");
                        }
                    }
                }
                else if(number == 5) {
                    int leftDistance = Math.abs(leftX - 2) + Math.abs(leftY -2);
                    int rightDistance = Math.abs(rightX - 2) + Math.abs(rightY -2);
                    if(leftDistance > rightDistance) {
                        rightX = 2;
                        rightY = 2;
                        sb.append("R");
                    }
                    else if(leftDistance < rightDistance) {
                        leftX= 2;
                        leftY = 2;
                        sb.append("L");
                    }
                    else {
                        if(hand.equals("right")) {
                            rightX = 2;
                            rightY = 2;
                            sb.append("R");
                        }
                        else {
                            leftX= 2;
                            leftY = 2;
                            sb.append("L");
                        }
                    }
                }
                else if(number == 8) {
                    int leftDistance = Math.abs(leftX - 3) + Math.abs(leftY -2);
                    int rightDistance = Math.abs(rightX - 3) + Math.abs(rightY -2);
                    if(leftDistance > rightDistance) {
                        rightX = 3;
                        rightY = 2;
                        sb.append("R");
                    }
                    else if(leftDistance < rightDistance){
                        leftX= 3;
                        leftY = 2;
                        sb.append("L");
                    }
                    else {
                        if(hand.equals("right")) {
                            rightX = 3;
                            rightY = 2;
                            sb.append("R");
                        }
                        else {
                            leftX= 3;
                            leftY = 2;
                            sb.append("L");
                        }
                    }
                    
                }
                else {
                    int leftDistance = Math.abs(leftX - 4) + Math.abs(leftY -2);
                    int rightDistance = Math.abs(rightX - 4) + Math.abs(rightY -2);
                    if(leftDistance > rightDistance) {
                        rightX = 4;
                        rightY = 2;
                        sb.append("R");
                    }
                    else if(leftDistance < rightDistance ){
                        leftX= 4;
                        leftY = 2;
                        sb.append("L");
                    }
                    else {
                        if(hand.equals("right")) {
                            rightX = 4;
                            rightY = 2;
                            sb.append("R");
                        }
                        else {
                            leftX= 4;
                            leftY = 2;
                            sb.append("L");
                        }
                    }
                }
            }
        }
        
        
        return sb.toString();
    }

}