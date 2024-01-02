import java.util.Scanner;

public class Main {

    private static final int MAX_ITEMS=100;
    private String[] malzemeIsmi;
    private double[] malzemeFiyati;
    private int cuzdan;
    private boolean sepetDolu;
    private int[] adet;


    public Main() {
        this.malzemeIsmi =new String[MAX_ITEMS];
        this.malzemeFiyati =new double[MAX_ITEMS];
        this.cuzdan =0;
        this.adet=new int[MAX_ITEMS];
    }
    public void kartaEkleme(String malzeme,double fiyati,int miktar){
        if (!sepetDolu){
            if (cuzdan<MAX_ITEMS) {
                malzemeIsmi[cuzdan] = malzeme;
                malzemeFiyati[cuzdan] = fiyati;
                adet[cuzdan] = miktar;


                cuzdan++;
                System.out.println(malzeme + " karta eklendi.");
            }
            else{
                System.out.println("Üzgünüm kart dolu.");
            }
        }
        else {
            System.out.println("Sepetiniz dolu sepeti temizleyiniz.");
        }

    }
    public void sepetiTemizle() {
        cuzdan = 0;
        sepetDolu = false;
        System.out.println("Sepet temizlendi.");
    }
    public void karttaSilme(int index) {
        if (index >= 0 && index < cuzdan) {
            for (int i = index; i < cuzdan - 1; i++) {
                malzemeIsmi[cuzdan] = malzemeIsmi[i + 1];
                malzemeFiyati[cuzdan] = malzemeFiyati[i + 1];
            }
            cuzdan--;

        } else {
            System.out.println("Üzgünüm ürün bulunamadı.");
        }
    }

    public void goster(){
        for (int i=0; i<cuzdan; i++){
            System.out.println(malzemeIsmi[i]+" " +adet[i]+" adet "+malzemeFiyati[i]+"TL");
        }
    }

    public void toplamTutar(boolean indirim){
        double toplam=0;

        for (int i=0; i<cuzdan; i++){
            if (indirim) {

                double toplamFiyat=adet[i] * (malzemeFiyati[i]*0.8);
                toplam +=toplamFiyat;
            }
            else {
                toplam += malzemeFiyati[i];
            }
        }
        System.out.println("İndirimli tutar : "+toplam);
    }

    public static void main(String[] args) {
        Main main=new Main();
        Scanner scanner=new Scanner(System.in);


        while (true){
        System.out.println("1. Karta ürün ekleme.");
        System.out.println("2. Kartı görüntüle.");
        System.out.println("3. Toplam tutar.");
        System.out.println("4. Ürün silme.");
        System.out.println("5. Sepeti temizle.");
        System.out.println("6. Çıkış yap.");


        System.out.println();
        System.out.println("İşlem seçiniz...");
        int islem=scanner.nextInt();
        scanner.nextLine();

        switch (islem){
            case 1:
                System.out.println("Lütfen ürün ismini giriniz.");
                String malzeme=scanner.nextLine();
                System.out.println("Lütfen fiyatı giriniz.");
                double fiyati=scanner.nextDouble();
                System.out.println("Lütfen adeti giriniz.");
                int miktar=scanner.nextInt();
                main.kartaEkleme(malzeme,fiyati,miktar);
                break;

            case 2:
                main.goster();
                break;
            case 3:
                boolean indirim=true;
                main.toplamTutar(indirim);
                break;
            case 4:
                System.out.println("Lütfen malzeme index giriniz");
                int kod=scanner.nextInt();
                main.karttaSilme(kod);
                break;
            case 5:
                main.sepetiTemizle();
                break;
            case 6:
                System.exit(0);
                break;
            default:
                System.out.println("Geçersiz işlem...");
        }
        }

    }
}