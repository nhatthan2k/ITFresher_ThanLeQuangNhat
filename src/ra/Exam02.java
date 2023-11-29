package ra;

import java.util.Scanner;

public class Exam02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("nhâp số hàng của mảng: ");
        int row = Integer.parseInt(scanner.nextLine());

        System.out.println("nhập số cột của mảng: ");
        int col = Integer.parseInt(scanner.nextLine());

        int[][] arr = new int[row][col];
        int sum;

        do {
            System.out.println("*********************MENU***********************");
            System.out.println("1. Nhập giá trị các phần tử của mảng");
            System.out.println("2. In giá trị các phần tử trong mảng theo ma trận");
            System.out.println("3. Tính số lượng các phần tử chia hết cho 2 và 3 trong mảng");
            System.out.println("4. In các phần tử và tổng các phần tử nằm trên đường biên, đường chéo chính và đường chéo phụ");
            System.out.println("5. Sử dụng thuật toán sắp xếp lựa chọn sắp xếp các phần tử tăng dần theo cột của mảng");
            System.out.println("6. In ra các phần tử là số nguyên tố trong mảng");
            System.out.println("7. Sử dụng thuật toán chèn (Insertion sort) sắp xếp các phần tử trên đường chéo chính của mảng giảm dần");
            System.out.println("8. Nhập giá trị một mảng 1 chiều gồm m phần tử và chỉ số dòng muốn chèn vào mảng, thực hiện chèn vào mảng 2 chiều");
            System.out.println("9. Thoát");
            System.out.println("lựa chọn của bạn: ");

            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1:
                    System.out.println("nhập giá trị các phần tử của mảng:");
                    for (int i=0; i<row; i++) {
                        for (int j=0; j<col; j++) {
                            System.out.printf("arr[%d][%d]: ", i, j);
                            arr[i][j] = Integer.parseInt(scanner.nextLine());
                        }
                    }
                    System.out.printf("\n");
                    break;
                case 2:
                    System.out.println("Các giá trị của mảng: ");
                    for (int i=0; i<row; i++) {
                        for (int j=0; j<col; j++) {
                            System.out.printf("%d\t", arr[i][j]);
                        }
                        System.out.printf("\n");
                    }
                    System.out.printf("\n");
                    break;
                case 3:
                    int k = 0;
                    for (int i=0; i<row; i++) {
                        for (int j=0; j<col; j++){
                            if(arr[i][j]%2==0 || arr[i][j]%3==0) {
                                k++;
                            }
                        }
                    }
                    System.out.printf("có %d số chia hết cho 2 và 3 trong mảng\n", k);
                    break;
                case 4:
                    int sumBorder = 0;
                    System.out.println("các phần tử đường biên của mảng là: ");
                    for (int i=0; i<row; i++) {
                        for (int j=0; j<col; j++) {
                            if(i==0 || i==row-1 || j==0 || j==col-1) {
                                sumBorder += arr[i][j];
                                System.out.printf("%d\t", arr[i][j]);
                            }else {
                                System.out.printf("\t");
                            }
                        }
                        System.out.printf("\n");
                    }
                    System.out.println("tổng giá trị đường viền là: " + sumBorder);

                    int sumOblique = 0;
                    System.out.println("các phần đường chéo chính và đường chéo phụ: ");
                    for (int i=0; i<row; i++) {
                        for (int j=0; j<col; j++) {
                            if(i==j || i+j==row-1) {
                                sumOblique += arr[i][j];
                                System.out.printf("%d\t", arr[i][j]);
                            }else {
                                System.out.printf("\t");
                            }
                        }
                        System.out.printf("\n");
                    }
                    System.out.println("tổng giá trị đường chéo là: " + sumOblique);
                    break;
                case 5:
                    System.out.println("giá trị mảng giảm dần theo cột: ");
                    for (int j=0; j<col; j++ ) {
                        for (int i=0; i<row-1; i++) {
                            int minIndex = i;

                            for (int n = i + 1; n < row; n++) {
                                if (arr[n][j] < arr[minIndex][j]) {
                                    minIndex = n;
                                }
                            }

                            int temp = arr[i][j];
                            arr[i][j] = arr[minIndex][j];
                            arr[minIndex][j] = temp;
                        }
                    }
                    break;
                case 6:
                    System.out.println("Các số nguyên tố có trong mảng là: ");
                    for (int i=0; i<row; i++) {
                        for(int j=0; j<col; j++) {
                            boolean isPrime = true;

                            if (arr[i][j]>=2) {
                                for (int n=2; n < Math.sqrt(arr[i][j]); n++) {
                                    if (arr[i][j]%n==0){
                                        isPrime = false;
                                        break;
                                    }
                                }
                            }else {
                                isPrime = false;
                            }

                            if(isPrime) {
                                System.out.printf("%d\t", arr[i][j]);
                            }else {
                                System.out.printf("\t");
                            }
                        }
                        System.out.printf("\n");
                    }
                    System.out.printf("\n");
                    break;
                case 7:
                    if (row==col) {
                        for (int i=0; i<row; i++) {
                            for (int j=0; j<col; j++) {
                                if(i==j) {
                                    int key = arr[i][j];
                                    int n = i-1;
                                    while (n>=0 && arr[n][n]< key) {
                                        arr[n+1][n+1] = arr[n][n];
                                        n = n - 1;
                                    }
                                    arr[n+1][n+1] = key;
                                }
                            }
                        }

                        System.out.println("Các giá trị của mảng: ");
                        for (int i=0; i<row; i++) {
                            for (int j=0; j<col; j++) {
                                System.out.printf("%d\t", arr[i][j]);
                            }
                            System.out.printf("\n");
                        }
                        System.out.printf("\n");

                    }else {
                        System.out.println("mảng không có đường chéo chính");
                    }

                    break;
                case 8:
                    int[] oneWayArr = new int[col];

                    System.out.println("Nhập giá trị mảng một chiều: ");
                    for (int i = 0; i < col; i++) {
                        oneWayArr[i] = Integer.parseInt(scanner.nextLine());
                    }

                    System.out.println("Nhập số dòng bạn cần chèn: ");
                    int insertRow = Integer.parseInt(scanner.nextLine());

                    int[][] newArr = new int[row + 1][col];

                    for (int i = 0; i < insertRow; i++) {
                        for (int j = 0; j < col; j++) {
                            newArr[i][j] = arr[i][j];
                        }
                    }

                    for (int j = 0; j < col; j++) {
                        newArr[insertRow][j] = oneWayArr[j];
                    }

                    for (int i = insertRow; i < row; i++) {
                        for (int j = 0; j < col; j++) {
                            newArr[i + 1][j] = arr[i][j];
                        }
                    }

                    for (int i = 0; i < newArr.length; i++) {
                        for (int j = 0; j < newArr[i].length; j++) {
                            System.out.printf("%d\t", newArr[i][j]);
                        }
                        System.out.println();
                    }
                    break;
                case 9:
                    System.exit(0);
                default:
                    System.out.println("nhập lựa chon 1-9");
            }
        }while (true);
    }
}
