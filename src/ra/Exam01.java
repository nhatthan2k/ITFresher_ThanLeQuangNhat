package ra;

import java.util.Scanner;

public class Exam01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] arr = new int[100];
        int numArr=0;
        int sum;

        do {
            System.out.println("***************MENU*****************");
            System.out.println("1. Nhập giá trị n phần tử của mảng (n nhập từ bàn phím)");
            System.out.println("2. In giá trị các phần tử trong mảng");
            System.out.println("3. Tính trung bình các phần tử dương (>0) trong mảng");
            System.out.println("4. In ra vị trí (chỉ số) các phần tử có giá trị bằng k trong mảng (k nhập từ bàn phím) ");
            System.out.println("5. Sử dụng thuật toán sắp xếp nổi bọt sắp xếp mảng giảm dần");
            System.out.println("6. Tính số lượng các phần tử là số nguyên tố trong mảng ");
            System.out.println("7. Sắp xếp các phần tử chẵn chia hết cho 3 ở đầu mảng theo thứ tự tăng dần, " +
                    "các phần tử lẻ chia hết cho 3 ở cuối mảng theo thứ tự giảm dần, " +
                    "các phần tử còn lại ở giữa mảng theo thứ tự tăng dần");
            System.out.println("8. Nhập giá trị m từ bàn phím, chèn giá trị m vào mảng (sắp xếp giảm dần) đúng vị trí");
            System.out.println("9. Thoát");
            System.out.println("lựa chon của bạn: ");

            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1:
                    System.out.println("nhập số phần tử của mảng:");
                    numArr = Integer.parseInt(scanner.nextLine());

                    for(int i=0; i<numArr; i++) {
                        System.out.printf("arr[%d]: ", i);
                        arr[i] = Integer.parseInt(scanner.nextLine());
                    }
                    break;
                case 2:
                    System.out.println("mảng của bạn là:");
                    for (int i=0; i<numArr; i++){
                        System.out.printf("%d\t", arr[i]);
                    }
                    System.out.printf("\n");
                    break;
                case 3:
                    sum = 0;
                    for (int i=0; i<numArr; i++) {
                        if(arr[i]>0) {
                            sum += arr[i];
                        }
                    }
                    System.out.println("trung bình các số dương trong mảng là: " + sum/2);
                    break;
                case 4:
                    System.out.println("nhâp giá trị cần tìm: ");
                    int k = Integer.parseInt(scanner.nextLine());

                    System.out.printf("vị trí các phần tử có giá trị %d là: ", k);
                    for (int i=0; i<numArr; i++) {
                        if(k==arr[i]){
                            System.out.printf("%d\n", i);
                        }
                    }
                    System.out.printf("\n");
                    break;
                case 5:
                    System.out.println("giá trị của mảng giảm dần là: ");
                    for (int i = 0; i<numArr-1; i++) {
                        for (int j = i + 1; j<numArr; j++ ){
                            if(arr[i]<arr[j]) {
                                 int temp = arr[i];
                                 arr[i] = arr[j];
                                 arr[j] = temp;
                            }
                        }
                    }
                    break;
                case 6:
                    System.out.println("số nguyên tố trong mang là: ");
                    for (int i=0; i< numArr; i++) {
                        boolean isprime = true;

                        if(arr[i]>=2) {
                            for (int j=2; j<Math.sqrt(arr[i]); j++ ){
                                if (arr[i]%j==0) {
                                    isprime = false;
                                    break;
                                }
                            }
                        }else {
                            isprime = false;
                        }

                        if (isprime) {
                            System.out.printf("%d\t", arr[i]);
                        }
                    }
                    System.out.printf("\n");
                    break;
                case 7:
                    break;
                case 8:
                    System.out.println("nhập vào giá trị cần thêm vào mảng:");
                    int insertNumber = Integer.parseInt(scanner.nextLine());

                    int[] newArr = new int[numArr + 1];

                    for(int i=0; i<numArr -1; i++) {
                        for (int j = i+1; j<numArr; j++) {
                            if (arr[i] < arr[j]) {
                                int temp = arr[i];
                                arr[i] = arr[j];
                                arr[j] = temp;
                            }
                        }
                    }

                    for (int i=0; i<newArr.length; i++) {
                        if(arr[i]>insertNumber) {
                            newArr[i] = arr[i];
                        }

                        newArr[i] = insertNumber;

                        if(arr[i]<insertNumber) {
                            newArr[i + 1] = arr[i];
                        }
                    }

                    System.out.println("mảng sau khi chèn: ");
                    for (int i=0; i<newArr.length; i++) {
                        System.out.printf("%d",newArr[i]);
                    }

                    break;
                case 9:
                    System.exit(0);
                default:
                    System.out.println("hãy chọn 1 - 9");
            }

        }while (true);

    }
}
