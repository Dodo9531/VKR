import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferByte;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.management.ManagementFactory;
import java.lang.management.MemoryMXBean;
import java.lang.management.OperatingSystemMXBean;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Interface extends JFrame {
    private static final int[] constants = {148, 32, 133, 16, 194, 192, 1, 251, 1, 192, 194, 16, 133, 32, 148, 1};
    static final int[] Pi = {
            0xfc, 0xee, 0xdd, 0x11, 0xcf, 0x6e, 0x31, 0x16,
            0xfb, 0xc4, 0xfa, 0xda, 0x23, 0xc5, 0x4, 0x4d,
            0xe9, 0x77, 0xf0, 0xdb, 0x93, 0x2e, 0x99, 0xba,
            0x17, 0x36, 0xf1, 0xbb, 0x14, 0xcd, 0x5f, 0xc1,
            0xf9, 0x18, 0x65, 0x5a, 0xe2, 0x5c, 0xef, 0x21,
            0x81, 0x1c, 0x3c, 0x42, 0x8b, 0x01, 0x8e, 0x4f,
            0x05, 0x84, 0x02, 0xae, 0xe3, 0x6a, 0x8f, 0xa0,
            0x06, 0x0b, 0xed, 0x98, 0x7f, 0xd4, 0xd3, 0x1f,
            0xeb, 0x34, 0x2c, 0x51, 0xea, 0xc8, 0x48, 0xab,
            0xf2, 0x2a, 0x68, 0xa2, 0xfd, 0x3a, 0xce, 0xcc,
            0xb5, 0x70, 0x0e, 0x56, 0x08, 0x0c, 0x76, 0x12,
            0xbf, 0x72, 0x13, 0x47, 0x9c, 0xb7, 0x5d, 0x87,
            0x15, 0xa1, 0x96, 0x29, 0x10, 0x7b, 0x9a, 0xc7,
            0xf3, 0x91, 0x78, 0x6f, 0x9d, 0x9e, 0xb2, 0xb1,
            0x32, 0x75, 0x19, 0x3d, 0xff, 0x35, 0x8a, 0x7e,
            0x6d, 0x54, 0xc6, 0x80, 0xc3, 0xbd, 0x0d, 0x57,
            0xdf, 0xf5, 0x24, 0xa9, 0x3e, 0xa8, 0x43, 0xc9,
            0xd7, 0x79, 0xd6, 0xf6, 0x7c, 0x22, 0xb9, 0x03,
            0xe0, 0x0f, 0xec, 0xde, 0x7a, 0x94, 0xb0, 0xbc,
            0xdc, 0xe8, 0x28, 0x50, 0x4e, 0x33, 0x0a, 0x4a,
            0xa7, 0x97, 0x60, 0x73, 0x1e, 0x00, 0x62, 0x44,
            0x1a, 0xb8, 0x38, 0x82, 0x64, 0x9f, 0x26, 0x41,
            0xad, 0x45, 0x46, 0x92, 0x27, 0x5e, 0x55, 0x2f,
            0x8c, 0xa3, 0xa5, 0x7d, 0x69, 0xd5, 0x95, 0x3b,
            0x07, 0x58, 0xb3, 0x40, 0x86, 0xac, 0x1d, 0xf7,
            0x30, 0x37, 0x6b, 0xe4, 0x88, 0xd9, 0xe7, 0x89,
            0xe1, 0x1b, 0x83, 0x49, 0x4c, 0x3f, 0xf8, 0xfe,
            0x8d, 0x53, 0xaa, 0x90, 0xca, 0xd8, 0x85, 0x61,
            0x20, 0x71, 0x67, 0xa4, 0x2d, 0x2b, 0x09, 0x5b,
            0xcb, 0x9b, 0x25, 0xd0, 0xbe, 0xe5, 0x6c, 0x52,
            0x59, 0xa6, 0x74, 0xd2, 0xe6, 0xf4, 0xb4, 0xc0,
            0xd1, 0x66, 0xaf, 0xc2, 0x39, 0x4b, 0x63, 0xb6};

    static final int[] reverse_Pi = {
            0xa5, 0x2d, 0x32, 0x8f, 0x0e, 0x30, 0x38, 0xc0,
            0x54, 0xe6, 0x9e, 0x39, 0x55, 0x7e, 0x52, 0x91,
            0x64, 0x03, 0x57, 0x5a, 0x1c, 0x60, 0x07, 0x18,
            0x21, 0x72, 0xa8, 0xd1, 0x29, 0xc6, 0xa4, 0x3f,
            0xe0, 0x27, 0x8d, 0x0c, 0x82, 0xea, 0xae, 0xb4,
            0x9a, 0x63, 0x49, 0xe5, 0x42, 0xe4, 0x15, 0xb7,
            0xc8, 0x06, 0x70, 0x9d, 0x41, 0x75, 0x19, 0xc9,
            0xaa, 0xfc, 0x4d, 0xbf, 0x2a, 0x73, 0x84, 0xd5,
            0xc3, 0xaf, 0x2b, 0x86, 0xa7, 0xb1, 0xb2, 0x5b,
            0x46, 0xd3, 0x9f, 0xfd, 0xd4, 0x0f, 0x9c, 0x2f,
            0x9b, 0x43, 0xef, 0xd9, 0x79, 0xb6, 0x53, 0x7f,
            0xc1, 0xf0, 0x23, 0xe7, 0x25, 0x5e, 0xb5, 0x1e,
            0xa2, 0xdf, 0xa6, 0xfe, 0xac, 0x22, 0xf9, 0xe2,
            0x4a, 0xbc, 0x35, 0xca, 0xee, 0x78, 0x05, 0x6b,
            0x51, 0xe1, 0x59, 0xa3, 0xf2, 0x71, 0x56, 0x11,
            0x6a, 0x89, 0x94, 0x65, 0x8c, 0xbb, 0x77, 0x3c,
            0x7b, 0x28, 0xab, 0xd2, 0x31, 0xde, 0xc4, 0x5f,
            0xcc, 0xcf, 0x76, 0x2c, 0xb8, 0xd8, 0x2e, 0x36,
            0xdb, 0x69, 0xb3, 0x14, 0x95, 0xbe, 0x62, 0xa1,
            0x3b, 0x16, 0x66, 0xe9, 0x5c, 0x6c, 0x6d, 0xad,
            0x37, 0x61, 0x4b, 0xb9, 0xe3, 0xba, 0xf1, 0xa0,
            0x85, 0x83, 0xda, 0x47, 0xc5, 0xb0, 0x33, 0xfa,
            0x96, 0x6f, 0x6e, 0xc2, 0xf6, 0x50, 0xff, 0x5d,
            0xa9, 0x8e, 0x17, 0x1b, 0x97, 0x7d, 0xec, 0x58,
            0xf7, 0x1f, 0xfb, 0x7c, 0x09, 0x0d, 0x7a, 0x67,
            0x45, 0x87, 0xdc, 0xe8, 0x4f, 0x1d, 0x4e, 0x04,
            0xeb, 0xf8, 0xf3, 0x3e, 0x3d, 0xbd, 0x8a, 0x88,
            0xdd, 0xcd, 0x0b, 0x13, 0x98, 0x02, 0x93, 0x80,
            0x90, 0xd0, 0x24, 0x34, 0xcb, 0xed, 0xf4, 0xce,
            0x99, 0x10, 0x44, 0x40, 0x92, 0x3a, 0x01, 0x26,
            0x12, 0x1a, 0x48, 0x68, 0xf5, 0x81, 0x8b, 0xc7,
            0xd6, 0x20, 0x0a, 0x08, 0x00, 0x4c, 0xd7, 0x74};


    private static final String key = "1110111111001101101010111000100101100111010001010010001100000001000100000011001001010100011101101001100010111010110111001111111001110111011001100101010101000100001100110010001000010001000000001111111111101110110111011100110010111011101010101001100110001000";
    private static final int[] gfpow2 = new int[256];
    private static int[] K1 = new int[16];
    private static int[] K2 = new int[16];
    private static final int[] gflog2 = new int[256];
    private static String[] gen_keys = new String[10];
    private static final int[][] C = new int[32][16];
    private JTextArea textField1;
    private JButton encryptButton;
    private JPanel mainPanel;
    private JTextArea textField3;
    private JButton decryptButton;
    private JRadioButton radioButton1;
    private JRadioButton radioButton2;
    private JRadioButton radioButton3;
    private JRadioButton radioButton4;
    private JRadioButton radioButton5;
    private JRadioButton radioButton6;
    private JTextArea textField2;
    private JPanel textPanel;
    private JLabel Label1;
    private JLabel Label2;
    private JLabel Label3;
    private JTabbedPane tabbedPane1;
    private JPanel imagePanel;
    private JRadioButton radioButton11;
    private JRadioButton radioButton22;
    private JRadioButton radioButton33;
    private JRadioButton radioButton44;
    private JRadioButton radioButton55;
    private JRadioButton radioButton66;
    private JButton encryptImageButton;
    private JButton decryptImageButton;
    private JButton loadImageToCipher;
    private JButton loadImageToDecipher;
    private JButton saveCipheredImage;
    private JButton saveDecipheredImage;
    private JPanel JPanelImageToCipher;
    private JPanel JPanelImageToDecipher;
    private JPanel JPanelImageDeciphered;
    private JLabel imageToCipherLabel;
    private JLabel imageToDecipherLabel;
    private JLabel imageDecipheredLabel;
    private JLabel ImageMACLabel;
    private BufferedImage imageCipher;
    private BufferedImage imageDecipher;
    private BufferedImage imageDeciphered;
    private File filePathCipher;
    private File filePathDecipher;
    private String cipherImageFormat;
    private int Perekl = 1;
    private int PereklImage = 1;
    private byte[] cipherByteFile;
    private byte[] decipherByteFile;
    private byte[] decipheredByteFile;
    private MemoryMXBean memoryBean;
    private OperatingSystemMXBean osBean;
    private com.sun.management.OperatingSystemMXBean customOsBean;
    private List<Double> CPUdata = new ArrayList<>();
    private List<Double> RAMdata = new ArrayList<>();
    private double usedTime;
    private double keyEntropy;
    private double cipherTextEntropy;
    private double cipherTextAutocorrelation;

    private double calculateKeyEntropy(int type) { // расчёт энтропии ключа
        double entropy;
        if (type == 0) {
            entropy = (((double) 1 / 256) * Math.log((double) 1 / 256)) * 32;
        } else {
            entropy = (((double) 1 / 256) * Math.log((double) 1 / 256)) * 32 + ((((double) 1 / 256) * Math.log((double) 1 / 256)) * 16);
        }
        return entropy;
    }

    private double calculateCipherTextEntropy(double textLength, String type) { // расчёт энтропии шифротекста
        return switch (type) {
            case "CTR" ->
                    (((double) 1 / 256) * Math.log((double) 1 / 256)) * textLength + ((((double) 1 / 256) * Math.log((double) 1 / 256)) * 16);
            case "OFB", "CFB" ->
                    (((double) 1 / 256) * Math.log((double) 1 / 256)) * textLength + ((((double) 1 / 256) * Math.log((double) 1 / 256)) * 16)
                            + ((((double) 1 / 256) * Math.log((double) 1 / 256)) * (textLength / 16));
            case "CBC" ->
                    ((((double) 1 / 256) * Math.log((double) 1 / 256)) * textLength + ((((double) 1 / 256) * Math.log((double) 1 / 256)) * 32)
                            + ((((double) 1 / 256) * Math.log((double) 1 / 256)) * (textLength / 16))) * 1.25;
            case "MAC" ->
                    (((double) 1 / 256) * Math.log((double) 1 / 256)) * textLength + ((((double) 1 / 256) * Math.log((double) 1 / 256)) * (textLength / 16));
            default -> (((double) 1 / 256) * Math.log((double) 1 / 256)) * textLength;
        };


    }

    private double calculateCipherTextAutocorrelation(byte[] bytes) { // расчёт автокорреляции шифротекста
        StringBuilder stringBuilder = new StringBuilder();
        for (int a : bytes) {
            stringBuilder.append(Integer.toBinaryString(a));
        }
        String cipherTextBits = stringBuilder.toString();
        double autoCorrelation = 0;
        for (int i = 0; i < cipherTextBits.length() - 1; i++) {
            autoCorrelation += cipherTextBits.charAt(i) ^ cipherTextBits.charAt(i + 1);
        }
        autoCorrelation = autoCorrelation / cipherTextBits.length();
        return autoCorrelation;
    }

    private static int[] XOR16(int[] a, int[] b) { // XOR для массивов размером 16
        int[] c = new int[16];
        for (int i = 0; i < 16; i++) {
            c[i] = a[i] ^ b[i];
        }
        return c;
    }

    private static int[] getintarrfromstring(String str) { // метод получения строки из интового массива
        int[] array = new int[16];
        for (int r = 0; r < 16; r++)
            array[r] = Integer.parseInt(str.substring(r * 8, 8 + r * 8), 2);
        return array;
    }

    private int[] arraysConcatForCBC(int[] a1, int[] a2) { // объединение массивов для режима CBC
        int[] a3 = Arrays.copyOf(a1, a1.length + a2.length);
        for (int i = a1.length; i < a3.length; i++) {
            a3[i] = a2[i - a1.length];
        }
        return a3;
    }

    private static boolean MSB(int[] a) { // проверка первого бита
        String str = Integer.toBinaryString(a[0]);
        return str.indexOf(0) == 0;
    }

    private static void getMACSubKeys() { // генерация доп ключей для режима MAC
        int[] int_gen_keys;
        int[] R = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        int[] B = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 135};
        for (int i = 0; i < 9; i++) {
            int_gen_keys = getintarrfromstring(gen_keys[i]);
            R = L(S(XOR16(R, int_gen_keys)));
        }
        int_gen_keys = getintarrfromstring(gen_keys[9]);
        R = XOR16(R, int_gen_keys);
        if (MSB(R)) {
            System.arraycopy(R, 1, K1, 0, 15);
            K1[15] = R[0];
        } else {
            System.arraycopy(R, 1, K1, 0, 15);
            K1[15] = R[0];
            K1 = XOR16(K1, B);
        }
        if (MSB(K1)) {
            System.arraycopy(K1, 1, K2, 0, 15);
            K2[15] = K1[0];
        } else {
            System.arraycopy(K1, 1, K2, 0, 15);
            K2[15] = K1[0];
            K2 = XOR16(K2, B);
        }
    }

    private static int[] S(int[] in) { // Операция S из кузнечика
        int[] out = new int[in.length];
        for (int i = 0; i < 16; i++) {
            int data = in[i];
            out[i] = Pi[data];
        }
        return out;
    }

    private int[] Reverse_S(int[] in) { // Обратный S
        int[] out = new int[in.length];
        for (int i = 0; i < 16; i++) {
            int data = in[i];
            out[i] = reverse_Pi[data];
        }
        return out;
    }

    private static int GFMUL(int a, int b) { // Умножение в полях галуа
        if (a == 0 || b == 0) {
            return 0;
        }
        int temp = gflog2[a] + gflog2[b];
        if (temp > 255) {
            temp = temp - 255;
        }
        return gfpow2[temp];
    }

    private static int[] L(int[] in) { // Операция L
        int[] out;
        int[] internal = in.clone();
        int a_0;
        for (int i = 1; i <= 16; i++) {
            a_0 = 0;
            for (int j = 0; j <= 15; j++)
                a_0 ^= GFMUL(internal[j], constants[j]);

            for (int j = 15; j > 0; j--)
                internal[j] = internal[j - 1];
            internal[0] = a_0;
        }
        out = internal;
        return out;
    }

    private int[] Reverse_L(int[] in) { // обратная операция L
        int[] out;
        int[] internal = in.clone();
        int a_15;
        for (int i = 1; i <= 16; i++) {


            int temp = internal[0];
            for (int j = 0; j < 15; j++) {
                internal[j] = internal[j + 1];
            }
            internal[15] = temp;

            a_15 = 0;
            for (int j = 0; j <= 15; j++)
                a_15 ^= GFMUL(internal[j], constants[j]);
            internal[15] = a_15;

        }
        out = internal;
        return out;
    }

    private double avgFromList(List<Double> list) { // Получение среднего числа из листа
        double sum = 0;
        for (double num : list) {
            sum += num;
        }
        return sum / list.size();
    }

    private void monitor(int keyType) { // Сбор данных о потребляемых ресурсах и времени на операцию
        memoryBean = ManagementFactory.getMemoryMXBean();
        osBean = ManagementFactory.getPlatformMXBean(OperatingSystemMXBean.class);
        customOsBean = (com.sun.management.OperatingSystemMXBean) osBean;
        CPUdata.add(customOsBean.getProcessCpuLoad() * 100);
        RAMdata.add((double) (memoryBean.getHeapMemoryUsage().getUsed() / 1048576 + memoryBean.getNonHeapMemoryUsage().getUsed() / 1048576));
        keyEntropy = calculateKeyEntropy(keyType);

    }

    private void showMonitor() { // метод выводящий сообщения с собранными данными
        String usedRAMFormated = String.format("%.3f", avgFromList(RAMdata));
        String usedCPUFormated = String.format("%.3f", avgFromList(CPUdata));
        String usedTimeFormated = String.format("%.3f", usedTime);
        String keyEntropyFormated = String.format("%.3f", keyEntropy);
        String cipherTextEntropyFormated = String.format("%.3f", cipherTextEntropy);
        String cipherTextAutocorrelationFormated = String.format("%.3f", cipherTextAutocorrelation);
        String monitorMsg = "Использованная ОЗУ: " + usedRAMFormated + " MB"
                + "\n" + "Использование процессора: " + usedCPUFormated + " %"
                + "\n" + "Потрачено времени на операцию: " + usedTimeFormated + " сек"
                + "\n" + "Энтропия ключа: " + keyEntropyFormated + " байт"
                + "\n" + "Энтропия шифротекста: " + cipherTextEntropyFormated + " байт"
                + "\n" + "Коэффициент автокорреляции зашифрованного текста: " + cipherTextAutocorrelationFormated;
        JOptionPane.showMessageDialog(null, monitorMsg, "Сведения", JOptionPane.INFORMATION_MESSAGE);
        CPUdata = new ArrayList<>();
        RAMdata = new ArrayList<>();
    }


    private static String[] gen_keys() { // Генерация ключей для кузнечика
        String[] gen_keys = new String[10];
        gen_keys[0] = key.substring(0, 128);
        gen_keys[1] = key.substring(128, 256);
        int[] key1;
        int[] key2;
        String k1 = gen_keys[0];
        String k2 = gen_keys[1];
        int[] bytetemp;
        String strtemp;
        for (int i = 1; i <= 4; i++) {
            if (i > 1) {
                k1 = gen_keys[2 * i - 2];
                k2 = gen_keys[2 * i - 1];
            }
            key1 = getintarrfromstring(k1);
            key2 = getintarrfromstring(k2);
            for (int j = 1; j <= 8; j++) {
                bytetemp = XOR16(key2, C[8 * (i - 1) + j - 1]);
                bytetemp = S(bytetemp);
                bytetemp = L(bytetemp);
                bytetemp = XOR16(bytetemp, key1);
                if (j == 8) {
                    k2 = "";
                    k1 = "";
                    for (int r = 0; r < 16; r++) {
                        strtemp = Integer.toBinaryString(key2[r]);
                        while (strtemp.length() < 8) {
                            strtemp = "0".concat(strtemp);
                        }
                        k2 = k2.concat(strtemp);
                    }
                    for (int r = 0; r <= 15; r++) {
                        strtemp = Integer.toBinaryString(bytetemp[r]);
                        while (strtemp.length() < 8) {
                            strtemp = "0".concat(strtemp);
                        }
                        k1 = k1.concat(strtemp);

                    }

                } else {
                    key1 = key2;
                    key2 = bytetemp;
                }
            }
            gen_keys[2 * i] = k2;
            gen_keys[2 * i + 1] = k1;

        }
        return gen_keys;
    }

    private byte[] genMAC(String msg) { // Генерация имитовставки для сообщений
        int[] int_gen_keys;
        List<Byte> byteList = new ArrayList<>();
        int[] ciphertext = null;
        int[] intblock = new int[16];
        boolean P = false;
        for (byte b : msg.getBytes(StandardCharsets.UTF_8)) // Переношу байты в лист
        {
            byteList.add(b);
        }
        while (byteList.size() % 16 != 0) { //Дополняю пробелами до величины байт кратной 16
            byteList.add((byte) 20);
            P = true;
        }
        int size = byteList.size() / 16;
        for (int c = 0; c < size; c++) {
            List<Byte> tempSubList = byteList.subList(c * 16, 16 * c + 16);

            intblock = new int[16];
            for (int i = 0; i < 16; i++) {
                intblock[i] = tempSubList.get(i);
            }
            for (int i = 0; i < intblock.length; i++) {
                if (intblock[i] >= 0) {
                    intblock[i] = tempSubList.get(i);
                } else {
                    intblock[i] = tempSubList.get(i) + 256;
                }
            }
            for (int i = 0; i < 9; i++) {

                int_gen_keys = getintarrfromstring(gen_keys[i]);
                intblock = L(S(XOR16(intblock, int_gen_keys)));

            }
            int_gen_keys = getintarrfromstring(gen_keys[9]);
            intblock = XOR16(intblock, int_gen_keys);
            if (ciphertext != null) {
                intblock = XOR16(ciphertext, intblock);
            }
            ciphertext = Arrays.copyOf(intblock, intblock.length);
        }
        if (P) {
            intblock = XOR16(K2, intblock);
        } else {
            intblock = XOR16(K1, intblock);
        }
        intblock = Arrays.copyOfRange(intblock, 0, 8);
        List<Byte> byteListOut = new ArrayList<>();
        for (int a : intblock) {
            byteListOut.add((byte) a);
        }
        byteListOut = byteListOut.subList(0, byteListOut.size());
        byte[] tempByte = new byte[byteListOut.size()];
        for (int i = 0; i < byteListOut.size(); i++) {
            tempByte[i] = byteListOut.get(i);
        }
        return tempByte;
    }

    private byte[] genMACImage(byte[] imageBytes) { // Генерация имитовставки для изображений
        int[] int_gen_keys;
        List<Byte> byteList = new ArrayList<>();
        for (byte b : imageBytes) // Переношу байты в лист
        {
            byteList.add(b);
        }
        int[] ciphertext = null;
        int[] intblock = new int[16];
        boolean P = false;

        while (byteList.size() % 16 != 0) { //Дополняю пробелами до величины байт кратной 16
            byteList.add((byte) 20);
            P = true;
        }
        int size = byteList.size() / 16;
        for (int c = 0; c < size; c++) {
            List<Byte> tempSubList = byteList.subList(c * 16, 16 * c + 16);

            intblock = new int[16];
            for (int i = 0; i < 16; i++) {
                intblock[i] = tempSubList.get(i);
            }
            for (int i = 0; i < intblock.length; i++) {
                if (intblock[i] >= 0) {
                    intblock[i] = tempSubList.get(i);
                } else {
                    intblock[i] = tempSubList.get(i) + 256;
                }
            }
            for (int i = 0; i < 9; i++) {

                int_gen_keys = getintarrfromstring(gen_keys[i]);
                intblock = L(S(XOR16(intblock, int_gen_keys)));

            }
            int_gen_keys = getintarrfromstring(gen_keys[9]);
            intblock = XOR16(intblock, int_gen_keys);
            if (ciphertext != null) {
                intblock = XOR16(ciphertext, intblock);
            }
            ciphertext = Arrays.copyOf(intblock, intblock.length);
        }
        if (P) {
            intblock = XOR16(K2, intblock);
        } else {
            intblock = XOR16(K1, intblock);
        }
        intblock = Arrays.copyOfRange(intblock, 0, 8);
        List<Byte> byteListOut = new ArrayList<>();
        for (int a : intblock) {
            byteListOut.add((byte) a);
        }
        byteListOut = byteListOut.subList(0, byteListOut.size());
        byte[] tempByte = new byte[byteListOut.size()];
        for (int i = 0; i < byteListOut.size(); i++) {
            tempByte[i] = byteListOut.get(i);
        }
        return tempByte;
    }

    private BufferedImage createBufferedImageFromBytes(byte[] imageBytes, int width, int height) {
        // создание изображения из байтов
        BufferedImage bufferedImage = new BufferedImage(width, height, BufferedImage.TYPE_4BYTE_ABGR);

        // Получаем DataBuffer и устанавливаем байты изображения
        DataBufferByte dataBuffer = (DataBufferByte) bufferedImage.getRaster().getDataBuffer();
        byte[] imgData = dataBuffer.getData();
        System.arraycopy(imageBytes, 0, imgData, 0, Math.min(imageBytes.length, imgData.length));

        // Если размер массива imageBytes больше, чем размер BufferedImage, оставшиеся байты будут проигнорированы

        return bufferedImage;
    }

    private List<Byte> imageReadEncrypt() { // чтение изображения для зашифрования
        List<Byte> byteList = new ArrayList<>();
        try (FileInputStream fis = new FileInputStream(filePathCipher.getAbsolutePath())) {
            int bytesRead;

            while ((bytesRead = fis.read()) != -1) {
                byteList.add((byte) bytesRead);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return byteList;
    }

    private void imageWriteEncrypt(byte[] tempByte) { // запись зашифрованного изображения
        decipherByteFile = tempByte;
        BufferedImage bufferedImage = createBufferedImageFromBytes(tempByte, imageCipher.getWidth() / 5, imageCipher.getHeight() / 5);
        imageToDecipherLabel.setIcon(new ImageIcon(bufferedImage.getScaledInstance(imageToDecipherLabel.getWidth(), imageToDecipherLabel.getHeight(), Image.SCALE_SMOOTH)));
        imageDecipher = bufferedImage;
        showMonitor();
    }

    private List<Byte> imageReadDecrypt() { // чтение зашифрованного сообщения
        List<Byte> byteList = new ArrayList<>();
        for (byte b : decipherByteFile) {
            byteList.add(b);
        }
        return byteList;

    }

    private void imageWriteDecrypt(byte[] tempByte) { // запись расшифрованного изображения
        decipheredByteFile = tempByte;
        BufferedImage img;
        try {
            img = ImageIO.read(new ByteArrayInputStream(tempByte));
            imageDecipheredLabel.setIcon(new ImageIcon(img.getScaledInstance(imageDecipheredLabel.getWidth(), imageDecipheredLabel.getHeight(), Image.SCALE_SMOOTH)));
            imageDeciphered = img;
            showMonitor();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void encryptImage() { // зашифрование изображения ECB
        int[] int_gen_keys;
        List<Byte> byteList = imageReadEncrypt();
        byte[] byteArray = new byte[byteList.size()];
        for (int i = 0; i < byteList.size(); i++) {
            byteArray[i] = byteList.get(i);
        }
        double ad = calculateCipherTextAutocorrelation(byteArray);
        double timeStart = (double) System.nanoTime() / 1000000000;
        while (byteList.size() % 16 != 0) { //Дополняю пробелами до величины байт кратной 16
            byteList.add((byte) 20);
        }

        int size = byteList.size() / 16;
        for (int c = 0; c < size; c++) {
            List<Byte> tempSubList = byteList.subList(c * 16, 16 * c + 16);
            if (c == size / 2 || c == size - 1) {
                monitor(0);
            }
            int[] intblock = new int[16];
            for (int i = 0; i < 16; i++) {
                intblock[i] = tempSubList.get(i);
            }
            for (int i = 0; i < intblock.length; i++) {
                if (intblock[i] >= 0) {
                    intblock[i] = tempSubList.get(i);
                } else {
                    intblock[i] = tempSubList.get(i) + 256;
                }
            }
            for (int i = 0; i < 9; i++) {

                int_gen_keys = getintarrfromstring(gen_keys[i]);
                intblock = L(S(XOR16(intblock, int_gen_keys)));

            }
            int_gen_keys = getintarrfromstring(gen_keys[9]);
            intblock = XOR16(intblock, int_gen_keys);


            for (int a : intblock) {
                byteList.add((byte) a);
            }
        }
        usedTime = (double) System.nanoTime() / 1000000000 - timeStart;
        byteList = byteList.subList(size * 16, byteList.size());
        byte[] tempByte = new byte[byteList.size()];
        for (int i = 0; i < byteList.size(); i++) {
            tempByte[i] = byteList.get(i);
        }
        cipherTextAutocorrelation = ad * calculateCipherTextAutocorrelation(tempByte);
        cipherTextEntropy = calculateCipherTextEntropy(tempByte.length, "");
        imageWriteEncrypt(tempByte);
    }

    private void decryptImage() { // // расшифрование изображения ECB
        int[] int_gen_keys;
        List<Byte> byteList = imageReadDecrypt();
        double timeStart = (double) System.nanoTime() / 1000000000;
        int size = byteList.size() / 16;
        for (int c = 0; c < size; c++) {
            List<Byte> tempSubList = byteList.subList(c * 16, 16 * c + 16);
            if (c == size / 2 || c == size - 1) {
                monitor(0);
            }
            int[] intblock = new int[16];
            for (int i = 0; i < 16; i++) {
                intblock[i] = tempSubList.get(i);
            }
            for (int i = 0; i < intblock.length; i++) {
                if (intblock[i] >= 0) {
                    intblock[i] = tempSubList.get(i);
                } else {
                    intblock[i] = tempSubList.get(i) + 256;
                }
            }
            for (int i = 9; i > 0; i--) {
                int_gen_keys = getintarrfromstring(gen_keys[i]);
                intblock = Reverse_S(Reverse_L(XOR16(intblock, int_gen_keys)));
            }
            int_gen_keys = getintarrfromstring(gen_keys[0]);
            intblock = XOR16(intblock, int_gen_keys);
            for (int a : intblock) {
                byteList.add((byte) a);
            }
        }
        usedTime = (double) System.nanoTime() / 1000000000 - timeStart;
        byteList = byteList.subList(size * 16, byteList.size());
        byte[] tempByte = new byte[byteList.size()];
        for (int i = 0; i < byteList.size(); i++) {
            tempByte[i] = byteList.get(i);
        }
        int to;
        if (byteList.contains((byte) 20)) {
            to = byteList.lastIndexOf((byte) 20) + 1;
            while (byteList.get(byteList.size() - 1) == 20) {
                byteList.remove(byteList.lastIndexOf((byte) 20));
                to--;
            }
        } else {
            to = size * 16;
        }

        tempByte = Arrays.copyOfRange(tempByte, 0, to);
        imageWriteDecrypt(tempByte);
    }

    private void encryptImageCFB() { // зашифрование изображения CFB
        int[] int_gen_keys;
        int[] IV = new int[]{63, 71, 110, 70, 36, 113, 52, 51, 0, 0, 0, 0, 0, 0, 0, 0};
        List<Byte> byteList = imageReadEncrypt();
        byte[] byteArray = new byte[byteList.size()];
        for (int i = 0; i < byteList.size(); i++) {
            byteArray[i] = byteList.get(i);
        }
        double ad = calculateCipherTextAutocorrelation(byteArray);
        double timeStart = (double) System.nanoTime() / 1000000000;
        while (byteList.size() % 16 != 0) { //Дополняю пробелами до величины байт кратной 16
            byteList.add((byte) 20);
        }
        int size = byteList.size() / 16;
        for (int c = 0; c < size; c++) {
            List<Byte> tempSubList = byteList.subList(c * 16, 16 * c + 16);
            if (c == size / 2 || c == size - 1) {
                monitor(1);
            }
            int[] intblock = new int[16];
            for (int i = 0; i < 16; i++) {
                intblock[i] = tempSubList.get(i);
            }
            for (int i = 0; i < intblock.length; i++) {
                if (intblock[i] >= 0) {
                    intblock[i] = tempSubList.get(i);
                } else {
                    intblock[i] = tempSubList.get(i) + 256;
                }
            }
            for (int i = 0; i < 9; i++) {
                int_gen_keys = getintarrfromstring(gen_keys[i]);
                IV = XOR16(IV, int_gen_keys);
                IV = S(IV);
                IV = L(IV);
            }
            int_gen_keys = getintarrfromstring(gen_keys[9]);
            IV = XOR16(IV, int_gen_keys); // конец зашифрования

            intblock = XOR16(intblock, IV);//Гаммирование блока данных с зашифрованным инициализирующим вектором
            IV = intblock;
            for (int a : intblock) {
                byteList.add((byte) a);
            }
        }
        usedTime = (double) System.nanoTime() / 1000000000 - timeStart;
        byteList = byteList.subList(size * 16, byteList.size());
        byte[] tempByte = new byte[byteList.size()];
        for (int i = 0; i < byteList.size(); i++) {
            tempByte[i] = byteList.get(i);
        }
        cipherTextAutocorrelation = ad * calculateCipherTextAutocorrelation(tempByte);
        cipherTextEntropy = calculateCipherTextEntropy(tempByte.length, "CFB");
        imageWriteEncrypt(tempByte);
    }

    private void decryptImageCFB() { // расшифрование изображения CFB
        int[] int_gen_keys;
        int[] IV = new int[]{63, 71, 110, 70, 36, 113, 52, 51, 0, 0, 0, 0, 0, 0, 0, 0};
        List<Byte> byteList = imageReadDecrypt();
        double timeStart = (double) System.nanoTime() / 1000000000;
        int size = byteList.size() / 16;
        for (int c = 0; c < size; c++) {
            List<Byte> tempSubList = byteList.subList(c * 16, 16 * c + 16);
            if (c == size / 2 || c == size - 1) {
                monitor(1);
            }
            int[] intblock = new int[16];
            for (int i = 0; i < 16; i++) {
                intblock[i] = tempSubList.get(i);
            }
            for (int i = 0; i < intblock.length; i++) {
                if (intblock[i] >= 0) {
                    intblock[i] = tempSubList.get(i);
                } else {
                    intblock[i] = tempSubList.get(i) + 256;
                }
            }
            for (int i = 0; i < 9; i++) {
                int_gen_keys = getintarrfromstring(gen_keys[i]);
                IV = L(S(XOR16(IV, int_gen_keys)));
            }
            int_gen_keys = getintarrfromstring(gen_keys[9]);
            IV = XOR16(IV, int_gen_keys); // конец зашифрования
            int[] tempIV = IV;
            IV = intblock;
            intblock = XOR16(intblock, tempIV);//Гаммирование блока данных с зашифрованным инициализирующим вектором

            for (int a : intblock) {
                byteList.add((byte) a);
            }
        }
        usedTime = (double) System.nanoTime() / 1000000000 - timeStart;
        byteList = byteList.subList(size * 16, byteList.size());
        byte[] tempByte = new byte[byteList.size()];
        for (int i = 0; i < byteList.size(); i++) {
            tempByte[i] = byteList.get(i);
        }
        int to;
        if (byteList.contains((byte) 20)) {
            to = byteList.lastIndexOf((byte) 20) + 1;
            while (byteList.get(byteList.size() - 1) == 20) {
                byteList.remove(byteList.lastIndexOf((byte) 20));
                to--;
            }
        } else {
            to = size * 16;
        }
        tempByte = Arrays.copyOfRange(tempByte, 0, to);
        imageWriteDecrypt(tempByte);
    }

    private void encryptImageOFB() { // зашифрование изображения OFB
        int[] int_gen_keys;
        int[] IV = new int[]{63, 71, 110, 70, 36, 113, 52, 51, 0, 0, 0, 0, 0, 0, 0, 0};
        List<Byte> byteList = imageReadEncrypt();
        byte[] byteArray = new byte[byteList.size()];
        for (int i = 0; i < byteList.size(); i++) {
            byteArray[i] = byteList.get(i);
        }
        double ad = calculateCipherTextAutocorrelation(byteArray);
        double timeStart = (double) System.nanoTime() / 1000000000;
        while (byteList.size() % 16 != 0) { //Дополняю пробелами до величины байт кратной 16
            byteList.add((byte) 20);
        }
        int size = byteList.size() / 16;
        for (int c = 0; c < size; c++) {
            List<Byte> tempSubList = byteList.subList(c * 16, 16 * c + 16);
            if (c == size / 2 || c == size - 1) {
                monitor(1);
            }
            int[] intblock = new int[16];
            for (int i = 0; i < 16; i++) {
                intblock[i] = tempSubList.get(i);
            }
            for (int i = 0; i < intblock.length; i++) {
                if (intblock[i] >= 0) {
                    intblock[i] = tempSubList.get(i);
                } else {
                    intblock[i] = tempSubList.get(i) + 256;
                }
            }
            for (int i = 0; i < 9; i++) {
                int_gen_keys = getintarrfromstring(gen_keys[i]);
                IV = XOR16(IV, int_gen_keys);
                IV = S(IV);
                IV = L(IV);
            }
            int_gen_keys = getintarrfromstring(gen_keys[9]);
            IV = XOR16(IV, int_gen_keys); // конец зашифрования
            intblock = XOR16(intblock, IV);//Гаммирование блока данных с зашифрованным инициализирующим вектором
            for (int a : intblock) {
                byteList.add((byte) a);
            }
        }
        usedTime = (double) System.nanoTime() / 1000000000 - timeStart;

        byteList = byteList.subList(size * 16, byteList.size());
        byte[] tempByte = new byte[byteList.size()];
        for (int i = 0; i < byteList.size(); i++) {
            tempByte[i] = byteList.get(i);
        }
        cipherTextAutocorrelation = ad * calculateCipherTextAutocorrelation(tempByte);
        cipherTextEntropy = calculateCipherTextEntropy(tempByte.length, "OFB");
        imageWriteEncrypt(tempByte);
    }

    private void decryptImageOFB() { // расшифрование изображения OFB
        int[] int_gen_keys;
        int[] IV = new int[]{63, 71, 110, 70, 36, 113, 52, 51, 0, 0, 0, 0, 0, 0, 0, 0};
        List<Byte> byteList = imageReadDecrypt();
        double timeStart = (double) System.nanoTime() / 1000000000;
        int size = byteList.size() / 16;
        for (int c = 0; c < size; c++) {
            List<Byte> tempSubList = byteList.subList(c * 16, 16 * c + 16);
            if (c == size / 2 || c == size - 1) {
                monitor(1);
            }
            int[] intblock = new int[16];
            for (int i = 0; i < 16; i++) {
                intblock[i] = tempSubList.get(i);
            }
            for (int i = 0; i < intblock.length; i++) {
                if (intblock[i] >= 0) {
                    intblock[i] = tempSubList.get(i);
                } else {
                    intblock[i] = tempSubList.get(i) + 256;
                }
            }
            IV = Arrays.copyOf(IV, 16); //копируем IV для зашифрования
            for (int i = 0; i < 9; i++) {
                int_gen_keys = getintarrfromstring(gen_keys[i]);
                IV = L(S(XOR16(IV, int_gen_keys)));
            }
            int_gen_keys = getintarrfromstring(gen_keys[9]);
            IV = XOR16(IV, int_gen_keys); // конец зашифрования

            intblock = XOR16(intblock, IV);//Гаммирование блока данных с зашифрованным инициализирующим вектором
            for (int a : intblock) {
                byteList.add((byte) a);
            }
        }
        usedTime = (double) System.nanoTime() / 1000000000 - timeStart;
        byteList = byteList.subList(size * 16, byteList.size());
        byte[] tempByte = new byte[byteList.size()];
        for (int i = 0; i < byteList.size(); i++) {
            tempByte[i] = byteList.get(i);
        }
        int to;
        if (byteList.contains((byte) 20)) {
            to = byteList.lastIndexOf((byte) 20) + 1;
            while (byteList.get(byteList.size() - 1) == 20) {
                byteList.remove(byteList.lastIndexOf((byte) 20));
                to--;
            }
        } else {
            to = size * 16;
        }
        tempByte = Arrays.copyOfRange(tempByte, 0, to);
        imageWriteDecrypt(tempByte);
    }

    private void encryptImageCTR() { // зашифрование изображения CTR
        int[] int_gen_keys;
        int[] IV_Encrypted;
        int[] IV = new int[]{63, 71, 110, 70, 36, 113, 52, 51, 0, 0, 0, 0, 0, 0, 0, 0};
        List<Byte> byteList = imageReadEncrypt();
        byte[] byteArray = new byte[byteList.size()];
        for (int i = 0; i < byteList.size(); i++) {
            byteArray[i] = byteList.get(i);
        }
        double ad = calculateCipherTextAutocorrelation(byteArray);
        double timeStart = (double) System.nanoTime() / 1000000000;
        while (byteList.size() % 16 != 0) { //Дополняю пробелами до величины байт кратной 16
            byteList.add((byte) 20);
        }
        int size = byteList.size() / 16;
        for (int c = 0; c < size; c++) {
            List<Byte> tempSubList = byteList.subList(c * 16, 16 * c + 16);
            if (c == size / 2 || c == size - 1) {
                monitor(1);
            }
            int[] intblock = new int[16];
            for (int i = 0; i < 16; i++) {
                intblock[i] = tempSubList.get(i);
            }
            for (int i = 0; i < intblock.length; i++) {
                if (intblock[i] >= 0) {
                    intblock[i] = tempSubList.get(i);
                } else {
                    intblock[i] = tempSubList.get(i) + 256;
                }
            }
            IV_Encrypted = Arrays.copyOf(IV, 16); //копируем IV для зашифрования
            for (int i = 0; i < 9; i++) {
                int_gen_keys = getintarrfromstring(gen_keys[i]);
                IV_Encrypted = XOR16(IV_Encrypted, int_gen_keys);
                IV_Encrypted = S(IV_Encrypted);
                IV_Encrypted = L(IV_Encrypted);
            }
            int_gen_keys = getintarrfromstring(gen_keys[9]);
            IV_Encrypted = XOR16(IV_Encrypted, int_gen_keys); // конец зашифрования

            intblock = XOR16(intblock, IV_Encrypted);//Гаммирование блока данных с зашифрованным инициализирующим вектором
            IV[15] += 1;
            if (IV[15] == 255) {
                IV[15] = 0;
                IV[14]++;
            }
            if (IV[14] == 255) {
                IV[14] = 0;
                IV[13]++;
            }
            if (IV[13] == 255) {
                IV[13] = 0;
                IV[12]++;
            }
            if (IV[12] == 255) {
                IV[12] = 0;
                IV[11]++;
            }
            if (IV[11] == 255) {
                IV[11] = 0;
                IV[10]++;
            }
            if (IV[10] == 255) {
                IV[10] = 0;
                IV[9]++;
            }
            if (IV[9] == 255) {
                IV[9] = 0;
                IV[8]++;
            }
            for (int a : intblock) {
                byteList.add((byte) a);
            }
        }
        usedTime = (double) System.nanoTime() / 1000000000 - timeStart;

        byteList = byteList.subList(size * 16, byteList.size());
        byte[] tempByte = new byte[byteList.size()];
        for (int i = 0; i < byteList.size(); i++) {
            tempByte[i] = byteList.get(i);
        }
        cipherTextAutocorrelation = ad * calculateCipherTextAutocorrelation(tempByte);
        cipherTextEntropy = calculateCipherTextEntropy(tempByte.length, "CTR");
        imageWriteEncrypt(tempByte);
    }

    private void decryptImageCTR() { // расшифрование изображения CTR
        int[] int_gen_keys;
        int[] IV_Encrypted;
        int[] IV = new int[]{63, 71, 110, 70, 36, 113, 52, 51, 0, 0, 0, 0, 0, 0, 0, 0};
        List<Byte> byteList = imageReadDecrypt();
        double timeStart = (double) System.nanoTime() / 1000000000;
        int size = byteList.size() / 16;
        for (int c = 0; c < size; c++) {
            List<Byte> tempSubList = byteList.subList(c * 16, 16 * c + 16);
            if (c == size / 2 || c == size - 1) {
                monitor(1);
            }
            int[] intblock = new int[16];
            for (int i = 0; i < 16; i++) {
                intblock[i] = tempSubList.get(i);
            }
            for (int i = 0; i < intblock.length; i++) {
                if (intblock[i] >= 0) {
                    intblock[i] = tempSubList.get(i);
                } else {
                    intblock[i] = tempSubList.get(i) + 256;
                }
            }
            IV_Encrypted = Arrays.copyOf(IV, 16); //копируем IV для зашифрования
            for (int i = 0; i < 9; i++) {
                int_gen_keys = getintarrfromstring(gen_keys[i]);
                IV_Encrypted = L(S(XOR16(IV_Encrypted, int_gen_keys)));
            }
            int_gen_keys = getintarrfromstring(gen_keys[9]);
            IV_Encrypted = XOR16(IV_Encrypted, int_gen_keys); // конец зашифрования

            intblock = XOR16(intblock, IV_Encrypted);//Гаммирование блока данных с зашифрованным инициализирующим вектором
            IV[15] += 1;
            if (IV[15] == 255) {
                IV[15] = 0;
                IV[14]++;
            }
            if (IV[14] == 255) {
                IV[14] = 0;
                IV[13]++;
            }
            if (IV[13] == 255) {
                IV[13] = 0;
                IV[12]++;
            }
            if (IV[12] == 255) {
                IV[12] = 0;
                IV[11]++;
            }
            if (IV[11] == 255) {
                IV[11] = 0;
                IV[10]++;
            }
            if (IV[10] == 255) {
                IV[10] = 0;
                IV[9]++;
            }
            if (IV[9] == 255) {
                IV[9] = 0;
                IV[8]++;
            }
            for (int a : intblock) {
                byteList.add((byte) a);
            }
        }
        usedTime = (double) System.nanoTime() / 1000000000 - timeStart;
        byteList = byteList.subList(size * 16, byteList.size());
        byte[] tempByte = new byte[byteList.size()];
        for (int i = 0; i < byteList.size(); i++) {
            tempByte[i] = byteList.get(i);
        }
        int to;
        if (byteList.contains((byte) 20)) {
            to = byteList.lastIndexOf((byte) 20) + 1;
            while (byteList.get(byteList.size() - 1) == 20) {
                byteList.remove(byteList.lastIndexOf((byte) 20));
                to--;
            }
        } else {
            to = size * 16;
        }
        tempByte = Arrays.copyOfRange(tempByte, 0, to);
        imageWriteDecrypt(tempByte);
    }

    private void encryptImageCBC() { // зашифрование изображения CBC
        int[] int_gen_keys;
        int[] IV = new int[]{63, 71, 110, 70, 36, 113, 52, 51, 209, 34, 182, 47, 88, 143, 201, 112, 55, 91, 168, 200, 14, 101, 235, 76};
        int[] n = Arrays.copyOf(IV, 16);
        List<Byte> byteList = imageReadEncrypt();
        byte[] byteArray = new byte[byteList.size()];
        for (int i = 0; i < byteList.size(); i++) {
            byteArray[i] = byteList.get(i);
        }
        double ad = calculateCipherTextAutocorrelation(byteArray);
        double timeStart = (double) System.nanoTime() / 1000000000;
        while (byteList.size() % 16 != 0) { //Дополняю пробелами до величины байт кратной 16
            byteList.add((byte) 20);
        }
        int size = byteList.size() / 16;
        for (int c = 0; c < size; c++) {
            List<Byte> tempSubList = byteList.subList(c * 16, 16 * c + 16);
            if (c == size / 2 || c == size - 1) {
                monitor(1);
            }
            int[] intblock = new int[16];
            for (int i = 0; i < 16; i++) {
                intblock[i] = tempSubList.get(i);
            }
            for (int i = 0; i < intblock.length; i++) {
                if (intblock[i] >= 0) {
                    intblock[i] = tempSubList.get(i);
                } else {
                    intblock[i] = tempSubList.get(i) + 256;
                }
            }
            intblock = XOR16(intblock, n);

            for (int i = 0; i < 9; i++) {
                int_gen_keys = getintarrfromstring(gen_keys[i]);
                intblock = XOR16(intblock, int_gen_keys);
                intblock = S(intblock);
                intblock = L(intblock);
            }
            int_gen_keys = getintarrfromstring(gen_keys[9]);
            intblock = XOR16(intblock, int_gen_keys); // конец зашифрования
            IV = arraysConcatForCBC(Arrays.copyOfRange(IV, 16, 24), intblock); // вставляю m-n бит в начало и шифротекст в конец
            n = Arrays.copyOf(IV, 16);
            for (int a : intblock) {
                byteList.add((byte) a);
            }
        }
        usedTime = (double) System.nanoTime() / 1000000000 - timeStart;

        byteList = byteList.subList(size * 16, byteList.size());
        byte[] tempByte = new byte[byteList.size()];
        for (int i = 0; i < byteList.size(); i++) {
            tempByte[i] = byteList.get(i);
        }
        cipherTextAutocorrelation = ad * calculateCipherTextAutocorrelation(tempByte);
        cipherTextEntropy = calculateCipherTextEntropy(tempByte.length, "CBC");
        imageWriteEncrypt(tempByte);
    }

    private void decryptImageCBC() { // расшифрование изображения CBC
        int[] int_gen_keys;
        int[] IV = new int[]{63, 71, 110, 70, 36, 113, 52, 51, 209, 34, 182, 47, 88, 143, 201, 112, 55, 91, 168, 200, 14, 101, 235, 76};
        int[] n = Arrays.copyOf(IV, 16);
        List<Byte> byteList = imageReadDecrypt();
        double timeStart = (double) System.nanoTime() / 1000000000;
        int size = byteList.size() / 16;
        for (int c = 0; c < size; c++) {
            List<Byte> tempSubList = byteList.subList(c * 16, 16 * c + 16);
            if (c == size / 2 || c == size - 1) {
                monitor(1);
            }
            int[] intblock = new int[16];
            for (int i = 0; i < 16; i++) {
                intblock[i] = tempSubList.get(i);
            }
            for (int i = 0; i < intblock.length; i++) {
                if (intblock[i] >= 0) {
                    intblock[i] = tempSubList.get(i);
                } else {
                    intblock[i] = tempSubList.get(i) + 256;
                }
            }
            n = Arrays.copyOf(IV, 16);
            IV = arraysConcatForCBC(Arrays.copyOfRange(IV, 16, 24), intblock); // вставляю m-n бит в начало и шифротекст в конец

            for (int i = 9; i > 0; i--) { // начало расшифрования блока
                int_gen_keys = getintarrfromstring(gen_keys[i]);
                intblock = Reverse_S(Reverse_L(XOR16(intblock, int_gen_keys)));
            }
            int_gen_keys = getintarrfromstring(gen_keys[0]);
            intblock = XOR16(intblock, int_gen_keys); // конец расшифрования блока

            intblock = XOR16(n, intblock);


            for (int a : intblock) {
                byteList.add((byte) a);
            }
        }
        usedTime = (double) System.nanoTime() / 1000000000 - timeStart;
        byteList = byteList.subList(size * 16, byteList.size());
        byte[] tempByte = new byte[byteList.size()];
        for (int i = 0; i < byteList.size(); i++) {
            tempByte[i] = byteList.get(i);
        }
        int to;
        if (byteList.contains((byte) 20)) {
            to = byteList.lastIndexOf((byte) 20) + 1;
            while (byteList.get(byteList.size() - 1) == 20) {
                byteList.remove(byteList.lastIndexOf((byte) 20));
                to--;
            }
        } else {
            to = size * 16;
        }
        tempByte = Arrays.copyOfRange(tempByte, 0, to);
        imageWriteDecrypt(tempByte);
    }

    private void encryptImageMAC() { // зашифрование изображения MAC
        int[] int_gen_keys;
        List<Byte> byteList = imageReadEncrypt();
        byte[] byteArray = new byte[byteList.size()];
        for (int i = 0; i < byteList.size(); i++) {
            byteArray[i] = byteList.get(i);
        }
        double ad = calculateCipherTextAutocorrelation(byteArray);
        byte[] imageBytes = new byte[byteList.size()];
        for (int i = 0; i < byteList.size(); i++) {
            imageBytes[i] = byteList.get(i);
        }
        double timeStart = (double) System.nanoTime() / 1000000000;
        byte[] MAC = genMACImage(imageBytes);
        while (byteList.size() % 16 != 0) { //Дополняю пробелами до величины байт кратной 16
            byteList.add((byte) 20);
        }
        int size = byteList.size() / 16;
        for (int c = 0; c < size; c++) {
            List<Byte> tempSubList = byteList.subList(c * 16, 16 * c + 16);
            if (c == size / 2 || c == size - 1) {
                monitor(1);
            }
            int[] intblock = new int[16];
            for (int i = 0; i < 16; i++) {
                intblock[i] = tempSubList.get(i);
            }
            for (int i = 0; i < intblock.length; i++) {
                if (intblock[i] >= 0) {
                    intblock[i] = tempSubList.get(i);
                } else {
                    intblock[i] = tempSubList.get(i) + 256;
                }
            }
            for (int i = 0; i < 9; i++) {

                int_gen_keys = getintarrfromstring(gen_keys[i]);
                intblock = L(S(XOR16(intblock, int_gen_keys)));

            }
            int_gen_keys = getintarrfromstring(gen_keys[9]);
            intblock = XOR16(intblock, int_gen_keys);


            for (int a : intblock) {
                byteList.add((byte) a);
            }
        }
        byteList = byteList.subList(size * 16, byteList.size());
        byte[] tempByte = new byte[byteList.size()];

        for (int i = 0; i < byteList.size(); i++) {
            tempByte[i] = byteList.get(i);
        }
        tempByte = Arrays.copyOf(tempByte, tempByte.length + 8);
        System.arraycopy(MAC, 0, tempByte, tempByte.length - 8, MAC.length);
        usedTime = (double) System.nanoTime() / 1000000000 - timeStart;
        cipherTextAutocorrelation = ad * calculateCipherTextAutocorrelation(tempByte);
        cipherTextEntropy = calculateCipherTextEntropy(imageBytes.length + 8, "MAC");
        showMonitor();
        imageWriteEncrypt(tempByte);
    }

    private void decryptImageMAC() { // расшифрование изображения MAC
        int[] int_gen_keys;
        List<Byte> byteList = imageReadDecrypt();
        double timeStart = (double) System.nanoTime() / 1000000000;
        byte[] MAC = new byte[8];
        for (int i = 0; i < 8; i++) {
            MAC[i] = byteList.get(i + byteList.size() - 8);
        }
        byteList = byteList.subList(0, byteList.size() - 8);
        int size = byteList.size() / 16;
        for (int c = 0; c < size; c++) {
            List<Byte> tempSubList = byteList.subList(c * 16, 16 * c + 16);
            if (c == size / 2 || c == size - 1) {
                monitor(0);
            }
            int[] intblock = new int[16];
            for (int i = 0; i < 16; i++) {
                intblock[i] = tempSubList.get(i);
            }
            for (int i = 0; i < intblock.length; i++) {
                if (intblock[i] >= 0) {
                    intblock[i] = tempSubList.get(i);
                } else {
                    intblock[i] = tempSubList.get(i) + 256;
                }
            }
            for (int i = 9; i > 0; i--) {
                int_gen_keys = getintarrfromstring(gen_keys[i]);
                intblock = Reverse_S(Reverse_L(XOR16(intblock, int_gen_keys)));
            }
            int_gen_keys = getintarrfromstring(gen_keys[0]);
            intblock = XOR16(intblock, int_gen_keys);
            for (int a : intblock) {
                byteList.add((byte) a);
            }
        }
        byteList = byteList.subList(size * 16, byteList.size());
        byte[] tempByte = new byte[byteList.size()];
        for (int i = 0; i < byteList.size(); i++) {
            tempByte[i] = byteList.get(i);
        }
        int to;
        if (byteList.contains((byte) 20)) {
            to = byteList.lastIndexOf((byte) 20) + 1;
            while (byteList.get(byteList.size() - 1) == 20) {
                byteList.remove(byteList.lastIndexOf((byte) 20));
                to--;
            }
        } else {
            to = size * 16;
        }
        tempByte = Arrays.copyOfRange(tempByte, 0, to);
        byte[] aaaaaaa = genMACImage(tempByte);
        usedTime = (double) System.nanoTime() / 1000000000 - timeStart;
        if (Arrays.equals(aaaaaaa, MAC)) {
            ImageMACLabel.setText("Изображение не подверглось изменениям");
        } else {
            ImageMACLabel.setText("Изображение было изменено");
        }
        imageWriteDecrypt(tempByte);


    }

    private String encrypt(String msg) { // зашифрование сообщения ECB
        int[] int_gen_keys;
        List<Byte> byteList = new ArrayList<>();

        for (byte b : msg.getBytes(StandardCharsets.UTF_8)) // Переношу байты в лист
        {
            byteList.add(b);
        }
        double ad = calculateCipherTextAutocorrelation(msg.getBytes(StandardCharsets.UTF_8));
        double timeStart = (double) System.nanoTime() / 1000000000;
        while (byteList.size() % 16 != 0) { //Дополняю пробелами до величины байт кратной 16
            byteList.add((byte) 20);
        }
        int size = byteList.size() / 16;
        for (int c = 0; c < size; c++) {
            List<Byte> tempSubList = byteList.subList(c * 16, 16 * c + 16);
            if (c == size / 2 || c == size - 1) {
                monitor(0);
            }
            int[] intblock = new int[16];
            for (int i = 0; i < 16; i++) {
                intblock[i] = tempSubList.get(i);
            }
            for (int i = 0; i < intblock.length; i++) {
                if (intblock[i] >= 0) {
                    intblock[i] = tempSubList.get(i);
                } else {
                    intblock[i] = tempSubList.get(i) + 256;
                }
            }
            for (int i = 0; i < 9; i++) {

                int_gen_keys = getintarrfromstring(gen_keys[i]);
                intblock = L(S(XOR16(intblock, int_gen_keys)));

            }
            int_gen_keys = getintarrfromstring(gen_keys[9]);
            intblock = XOR16(intblock, int_gen_keys);
            for (int a : intblock) {
                byteList.add((byte) a);
            }
        }
        usedTime = (double) System.nanoTime() / 1000000000 - timeStart;
        byteList = byteList.subList(size * 16, byteList.size());
        byte[] tempByte = new byte[byteList.size()];
        for (int i = 0; i < byteList.size(); i++) {
            tempByte[i] = byteList.get(i);
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < tempByte.length; i++) {
            stringBuilder.append(tempByte[i]).append(" ");
            if (i % 16 == 0 && i != 0) {
                stringBuilder.append("\n");
            }
        }
        cipherTextAutocorrelation = ad * calculateCipherTextAutocorrelation(tempByte);
        cipherTextEntropy = calculateCipherTextEntropy(tempByte.length, "");
        showMonitor();
        return stringBuilder.toString();
    }

    private String decrypt(String msg) { // расшифрование сообщения ECB
        int[] int_gen_keys;
        List<Byte> byteList = new ArrayList<>();
        try (Scanner scanner = new Scanner(msg)) {
            while (scanner.hasNext()) {
                if (scanner.hasNextByte()) {
                    byteList.add(scanner.nextByte());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        double timeStart = (double) System.nanoTime() / 1000000000;
        int size = byteList.size() / 16;
        for (int c = 0; c < size; c++) {
            List<Byte> tempSubList = byteList.subList(c * 16, 16 * c + 16);
            if (c == size / 2 || c == size - 1) {
                monitor(0);
            }
            int[] intblock = new int[16];
            for (int i = 0; i < 16; i++) {
                intblock[i] = tempSubList.get(i);
            }
            for (int i = 0; i < intblock.length; i++) {
                if (intblock[i] >= 0) {
                    intblock[i] = tempSubList.get(i);
                } else {
                    intblock[i] = tempSubList.get(i) + 256;
                }
            }
            for (int i = 9; i > 0; i--) {
                int_gen_keys = getintarrfromstring(gen_keys[i]);
                intblock = Reverse_S(Reverse_L(XOR16(intblock, int_gen_keys)));
            }
            int_gen_keys = getintarrfromstring(gen_keys[0]);
            intblock = XOR16(intblock, int_gen_keys);
            for (int a : intblock) {
                byteList.add((byte) a);
            }
        }
        usedTime = (double) System.nanoTime() / 1000000000 - timeStart;
        byteList = byteList.subList(size * 16, byteList.size());
        byte[] tempByte = new byte[byteList.size()];
        for (int i = 0; i < byteList.size(); i++) {
            tempByte[i] = byteList.get(i);
        }
        int to;
        if (byteList.contains((byte) 20)) {
            to = byteList.indexOf((byte) 20);
        } else {
            to = size * 16;
        }

        tempByte = Arrays.copyOfRange(tempByte, 0, to);
        showMonitor();
        return new String(tempByte, StandardCharsets.UTF_8);
    }

    private String encryptCFB(String msg) { // зашифрование сообщения CFB
        int[] int_gen_keys;
        int[] IV = new int[]{63, 71, 110, 70, 36, 113, 52, 51, 0, 0, 0, 0, 0, 0, 0, 0};
        List<Byte> byteList = new ArrayList<>();
        for (byte b : msg.getBytes(StandardCharsets.UTF_8)) // Переношу байты в лист
        {
            byteList.add(b);
        }
        double ad = calculateCipherTextAutocorrelation(msg.getBytes(StandardCharsets.UTF_8));
        double timeStart = (double) System.nanoTime() / 1000000000;
        while (byteList.size() % 16 != 0) { //Дополняю пробелами до величины байт кратной 16
            byteList.add((byte) 20);
        }
        int size = byteList.size() / 16;
        for (int c = 0; c < size; c++) {
            List<Byte> tempSubList = byteList.subList(c * 16, 16 * c + 16);
            if (c == size / 2 || c == size - 1) {
                monitor(1);
            }
            int[] intblock = new int[16];
            for (int i = 0; i < 16; i++) {
                intblock[i] = tempSubList.get(i);
            }
            for (int i = 0; i < intblock.length; i++) {
                if (intblock[i] >= 0) {
                    intblock[i] = tempSubList.get(i);
                } else {
                    intblock[i] = tempSubList.get(i) + 256;
                }
            }
            for (int i = 0; i < 9; i++) {
                int_gen_keys = getintarrfromstring(gen_keys[i]);
                IV = XOR16(IV, int_gen_keys);
                IV = S(IV);
                IV = L(IV);
            }
            int_gen_keys = getintarrfromstring(gen_keys[9]);
            IV = XOR16(IV, int_gen_keys); // конец зашифрования

            intblock = XOR16(intblock, IV);//Гаммирование блока данных с зашифрованным инициализирующим вектором
            IV = intblock;
            for (int a : intblock) {
                byteList.add((byte) a);
            }
        }
        usedTime = (double) System.nanoTime() / 1000000000 - timeStart;
        byteList = byteList.subList(size * 16, byteList.size());
        byte[] tempByte = new byte[byteList.size()];
        for (int i = 0; i < byteList.size(); i++) {
            tempByte[i] = byteList.get(i);
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < tempByte.length; i++) {
            stringBuilder.append(tempByte[i]).append(" ");
            if (i % 16 == 0 && i != 0) {
                stringBuilder.append("\n");
            }
        }
        cipherTextAutocorrelation = ad * calculateCipherTextAutocorrelation(tempByte);
        cipherTextEntropy = calculateCipherTextEntropy(tempByte.length, "CFB");
        showMonitor();
        return stringBuilder.toString();
    }

    private String decryptCFB(String msg) { // расшифрование сообщения CFB
        int[] int_gen_keys;
        int[] IV = new int[]{63, 71, 110, 70, 36, 113, 52, 51, 0, 0, 0, 0, 0, 0, 0, 0};
        List<Byte> byteList = new ArrayList<>();
        try (Scanner scanner = new Scanner(msg)) {
            while (scanner.hasNext()) {
                if (scanner.hasNextByte()) {
                    byteList.add(scanner.nextByte());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        double timeStart = (double) System.nanoTime() / 1000000000;
        int size = byteList.size() / 16;
        for (int c = 0; c < size; c++) {
            List<Byte> tempSubList = byteList.subList(c * 16, 16 * c + 16);
            if (c == size / 2 || c == size - 1) {
                monitor(1);
            }
            int[] intblock = new int[16];
            for (int i = 0; i < 16; i++) {
                intblock[i] = tempSubList.get(i);
            }
            for (int i = 0; i < intblock.length; i++) {
                if (intblock[i] >= 0) {
                    intblock[i] = tempSubList.get(i);
                } else {
                    intblock[i] = tempSubList.get(i) + 256;
                }
            }
            for (int i = 0; i < 9; i++) {
                int_gen_keys = getintarrfromstring(gen_keys[i]);
                IV = L(S(XOR16(IV, int_gen_keys)));
            }
            int_gen_keys = getintarrfromstring(gen_keys[9]);
            IV = XOR16(IV, int_gen_keys); // конец зашифрования
            int[] tempIV = IV;
            IV = intblock;
            intblock = XOR16(intblock, tempIV);//Гаммирование блока данных с зашифрованным инициализирующим вектором

            for (int a : intblock) {
                byteList.add((byte) a);
            }
        }
        usedTime = (double) System.nanoTime() / 1000000000 - timeStart;
        byteList = byteList.subList(size * 16, byteList.size());
        byte[] tempByte = new byte[byteList.size()];
        for (int i = 0; i < byteList.size(); i++) {
            tempByte[i] = byteList.get(i);
        }
        int to;
        if (byteList.contains((byte) 20)) {
            to = byteList.indexOf((byte) 20);
        } else {
            to = size * 16;
        }
        tempByte = Arrays.copyOfRange(tempByte, 0, to);
        showMonitor();
        return new String(tempByte, StandardCharsets.UTF_8);
    }

    private String encryptOFB(String msg) { // зашифрование сообщения OFB
        int[] int_gen_keys;
        int[] IV = new int[]{63, 71, 110, 70, 36, 113, 52, 51, 0, 0, 0, 0, 0, 0, 0, 0};
        List<Byte> byteList = new ArrayList<>();
        for (byte b : msg.getBytes(StandardCharsets.UTF_8)) // Переношу байты в лист
        {
            byteList.add(b);
        }
        double ad = calculateCipherTextAutocorrelation(msg.getBytes(StandardCharsets.UTF_8));
        while (byteList.size() % 16 != 0) { //Дополняю пробелами до величины байт кратной 16
            byteList.add((byte) 20);
        }
        double timeStart = (double) System.nanoTime() / 1000000000;
        int size = byteList.size() / 16;
        for (int c = 0; c < size; c++) {
            List<Byte> tempSubList = byteList.subList(c * 16, 16 * c + 16);
            if (c == size / 2 || c == size - 1) {
                monitor(1);
            }
            int[] intblock = new int[16];
            for (int i = 0; i < 16; i++) {
                intblock[i] = tempSubList.get(i);
            }
            for (int i = 0; i < intblock.length; i++) {
                if (intblock[i] >= 0) {
                    intblock[i] = tempSubList.get(i);
                } else {
                    intblock[i] = tempSubList.get(i) + 256;
                }
            }
            for (int i = 0; i < 9; i++) {
                int_gen_keys = getintarrfromstring(gen_keys[i]);
                IV = XOR16(IV, int_gen_keys);
                IV = S(IV);
                IV = L(IV);
            }
            int_gen_keys = getintarrfromstring(gen_keys[9]);
            IV = XOR16(IV, int_gen_keys); // конец зашифрования
            intblock = XOR16(intblock, IV);//Гаммирование блока данных с зашифрованным инициализирующим вектором
            for (int a : intblock) {
                byteList.add((byte) a);
            }
        }
        usedTime = (double) System.nanoTime() / 1000000000 - timeStart;
        byteList = byteList.subList(size * 16, byteList.size());
        byte[] tempByte = new byte[byteList.size()];
        for (int i = 0; i < byteList.size(); i++) {
            tempByte[i] = byteList.get(i);
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < tempByte.length; i++) {
            stringBuilder.append(tempByte[i]).append(" ");
            if (i % 16 == 0 && i != 0) {
                stringBuilder.append("\n");
            }
        }
        cipherTextAutocorrelation = ad * calculateCipherTextAutocorrelation(tempByte);
        cipherTextEntropy = calculateCipherTextEntropy(tempByte.length, "OFB");
        showMonitor();
        return stringBuilder.toString();
    }

    private String decryptOFB(String msg) { // расшифрование сообщения OFB
        int[] int_gen_keys;
        int[] IV = new int[]{63, 71, 110, 70, 36, 113, 52, 51, 0, 0, 0, 0, 0, 0, 0, 0};
        List<Byte> byteList = new ArrayList<>();
        try (Scanner scanner = new Scanner(msg)) {
            while (scanner.hasNext()) {
                if (scanner.hasNextByte()) {
                    byteList.add(scanner.nextByte());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        double timeStart = (double) System.nanoTime() / 1000000000;
        int size = byteList.size() / 16;
        for (int c = 0; c < size; c++) {
            List<Byte> tempSubList = byteList.subList(c * 16, 16 * c + 16);
            if (c == size / 2 || c == size - 1) {
                monitor(1);
            }
            int[] intblock = new int[16];
            for (int i = 0; i < 16; i++) {
                intblock[i] = tempSubList.get(i);
            }
            for (int i = 0; i < intblock.length; i++) {
                if (intblock[i] >= 0) {
                    intblock[i] = tempSubList.get(i);
                } else {
                    intblock[i] = tempSubList.get(i) + 256;
                }
            }
            IV = Arrays.copyOf(IV, 16); //копируем IV для зашифрования
            for (int i = 0; i < 9; i++) {
                int_gen_keys = getintarrfromstring(gen_keys[i]);
                IV = L(S(XOR16(IV, int_gen_keys)));
            }
            int_gen_keys = getintarrfromstring(gen_keys[9]);
            IV = XOR16(IV, int_gen_keys); // конец зашифрования

            intblock = XOR16(intblock, IV);//Гаммирование блока данных с зашифрованным инициализирующим вектором
            for (int a : intblock) {
                byteList.add((byte) a);
            }
        }
        usedTime = (double) System.nanoTime() / 1000000000 - timeStart;
        byteList = byteList.subList(size * 16, byteList.size());
        byte[] tempByte = new byte[byteList.size()];
        for (int i = 0; i < byteList.size(); i++) {
            tempByte[i] = byteList.get(i);
        }
        int to;
        if (byteList.contains((byte) 20)) {
            to = byteList.indexOf((byte) 20);
        } else {
            to = size * 16;
        }
        tempByte = Arrays.copyOfRange(tempByte, 0, to);
        showMonitor();
        return new String(tempByte, StandardCharsets.UTF_8);
    }

    private String encryptCTR(String msg) { // зашифрование сообщения CTR
        int[] int_gen_keys;
        int[] IV_Encrypted;
        int[] IV = new int[]{63, 71, 110, 70, 36, 113, 52, 51, 0, 0, 0, 0, 0, 0, 0, 0};
        List<Byte> byteList = new ArrayList<>();
        for (byte b : msg.getBytes(StandardCharsets.UTF_8)) // Переношу байты в лист
        {
            byteList.add(b);
        }
        double ad = calculateCipherTextAutocorrelation(msg.getBytes(StandardCharsets.UTF_8));
        while (byteList.size() % 16 != 0) { //Дополняю пробелами до величины байт кратной 16
            byteList.add((byte) 20);
        }
        double timeStart = (double) System.nanoTime() / 1000000000;
        int size = byteList.size() / 16;
        for (int c = 0; c < size; c++) {
            List<Byte> tempSubList = byteList.subList(c * 16, 16 * c + 16);
            if (c == size / 2 || c == size - 1) {
                monitor(1);
            }
            int[] intblock = new int[16];
            for (int i = 0; i < 16; i++) {
                intblock[i] = tempSubList.get(i);
            }
            for (int i = 0; i < intblock.length; i++) {
                if (intblock[i] >= 0) {
                    intblock[i] = tempSubList.get(i);
                } else {
                    intblock[i] = tempSubList.get(i) + 256;
                }
            }
            IV_Encrypted = Arrays.copyOf(IV, 16); //копируем IV для зашифрования
            for (int i = 0; i < 9; i++) {
                int_gen_keys = getintarrfromstring(gen_keys[i]);
                IV_Encrypted = XOR16(IV_Encrypted, int_gen_keys);
                IV_Encrypted = S(IV_Encrypted);
                IV_Encrypted = L(IV_Encrypted);
            }
            int_gen_keys = getintarrfromstring(gen_keys[9]);
            IV_Encrypted = XOR16(IV_Encrypted, int_gen_keys); // конец зашифрования

            intblock = XOR16(intblock, IV_Encrypted);//Гаммирование блока данных с зашифрованным инициализирующим вектором
            IV[15] += 1;
            if (IV[15] == 255) {
                IV[15] = 0;
                IV[14]++;
            }
            if (IV[14] == 255) {
                IV[14] = 0;
                IV[13]++;
            }
            if (IV[13] == 255) {
                IV[13] = 0;
                IV[12]++;
            }
            if (IV[12] == 255) {
                IV[12] = 0;
                IV[11]++;
            }
            if (IV[11] == 255) {
                IV[11] = 0;
                IV[10]++;
            }
            if (IV[10] == 255) {
                IV[10] = 0;
                IV[9]++;
            }
            if (IV[9] == 255) {
                IV[9] = 0;
                IV[8]++;
            }
            for (int a : intblock) {
                byteList.add((byte) a);
            }
        }
        usedTime = (double) System.nanoTime() / 1000000000 - timeStart;
        byteList = byteList.subList(size * 16, byteList.size());
        byte[] tempByte = new byte[byteList.size()];
        for (int i = 0; i < byteList.size(); i++) {
            tempByte[i] = byteList.get(i);
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < tempByte.length; i++) {
            stringBuilder.append(tempByte[i]).append(" ");
            if (i % 16 == 0 && i != 0) {
                stringBuilder.append("\n");
            }
        }
        cipherTextAutocorrelation = ad * calculateCipherTextAutocorrelation(tempByte);
        cipherTextEntropy = calculateCipherTextEntropy(tempByte.length, "CTR");
        showMonitor();
        return stringBuilder.toString();
    }

    private String decryptCTR(String msg) { // расшифрование сообщения CTR
        int[] int_gen_keys;
        int[] IV_Encrypted;
        int[] IV = new int[]{63, 71, 110, 70, 36, 113, 52, 51, 0, 0, 0, 0, 0, 0, 0, 0};
        List<Byte> byteList = new ArrayList<>();
        try (Scanner scanner = new Scanner(msg)) {
            while (scanner.hasNext()) {
                if (scanner.hasNextByte()) {
                    byteList.add(scanner.nextByte());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        double timeStart = (double) System.nanoTime() / 1000000000;
        int size = byteList.size() / 16;
        for (int c = 0; c < size; c++) {
            List<Byte> tempSubList = byteList.subList(c * 16, 16 * c + 16);
            if (c == size / 2 || c == size - 1) {
                monitor(1);
            }
            int[] intblock = new int[16];
            for (int i = 0; i < 16; i++) {
                intblock[i] = tempSubList.get(i);
            }
            for (int i = 0; i < intblock.length; i++) {
                if (intblock[i] >= 0) {
                    intblock[i] = tempSubList.get(i);
                } else {
                    intblock[i] = tempSubList.get(i) + 256;
                }
            }
            IV_Encrypted = Arrays.copyOf(IV, 16); //копируем IV для зашифрования
            for (int i = 0; i < 9; i++) {
                int_gen_keys = getintarrfromstring(gen_keys[i]);
                IV_Encrypted = L(S(XOR16(IV_Encrypted, int_gen_keys)));
            }
            int_gen_keys = getintarrfromstring(gen_keys[9]);
            IV_Encrypted = XOR16(IV_Encrypted, int_gen_keys); // конец зашифрования

            intblock = XOR16(intblock, IV_Encrypted);//Гаммирование блока данных с зашифрованным инициализирующим вектором
            IV[15] += 1;
            if (IV[15] == 255) {
                IV[15] = 0;
                IV[14]++;
            }
            if (IV[14] == 255) {
                IV[14] = 0;
                IV[13]++;
            }
            if (IV[13] == 255) {
                IV[13] = 0;
                IV[12]++;
            }
            if (IV[12] == 255) {
                IV[12] = 0;
                IV[11]++;
            }
            if (IV[11] == 255) {
                IV[11] = 0;
                IV[10]++;
            }
            if (IV[10] == 255) {
                IV[10] = 0;
                IV[9]++;
            }
            if (IV[9] == 255) {
                IV[9] = 0;
                IV[8]++;
            }
            for (int a : intblock) {
                byteList.add((byte) a);
            }
        }
        usedTime = (double) System.nanoTime() / 1000000000 - timeStart;
        byteList = byteList.subList(size * 16, byteList.size());
        byte[] tempByte = new byte[byteList.size()];
        for (int i = 0; i < byteList.size(); i++) {
            tempByte[i] = byteList.get(i);
        }
        int to;
        if (byteList.contains((byte) 20)) {
            to = byteList.indexOf((byte) 20);
        } else {
            to = size * 16;
        }
        tempByte = Arrays.copyOfRange(tempByte, 0, to);
        showMonitor();
        return new String(tempByte, StandardCharsets.UTF_8);
    }

    private String encryptCBC(String msg) { // зашифрование сообщения CBC
        int[] int_gen_keys;
        int[] IV = new int[]{63, 71, 110, 70, 36, 113, 52, 51, 209, 34, 182, 47, 88, 143, 201, 112, 55, 91, 168, 200, 14, 101, 235, 76};
        int[] n = Arrays.copyOf(IV, 16);
        List<Byte> byteList = new ArrayList<>();
        for (byte b : msg.getBytes(StandardCharsets.UTF_8)) // Переношу байты в лист
        {
            byteList.add(b);
        }
        double ad = calculateCipherTextAutocorrelation(msg.getBytes(StandardCharsets.UTF_8));
        double timeStart = (double) System.nanoTime() / 1000000000;
        while (byteList.size() % 16 != 0) { //Дополняю пробелами до величины байт кратной 16
            byteList.add((byte) 20);
        }
        int size = byteList.size() / 16;
        for (int c = 0; c < size; c++) {
            List<Byte> tempSubList = byteList.subList(c * 16, 16 * c + 16);
            if (c == size / 2 || c == size - 1) {
                monitor(1);
            }
            int[] intblock = new int[16];
            for (int i = 0; i < 16; i++) {
                intblock[i] = tempSubList.get(i);
            }
            for (int i = 0; i < intblock.length; i++) {
                if (intblock[i] >= 0) {
                    intblock[i] = tempSubList.get(i);
                } else {
                    intblock[i] = tempSubList.get(i) + 256;
                }
            }
            intblock = XOR16(intblock, n);

            for (int i = 0; i < 9; i++) {
                int_gen_keys = getintarrfromstring(gen_keys[i]);
                intblock = XOR16(intblock, int_gen_keys);
                intblock = S(intblock);
                intblock = L(intblock);
            }
            int_gen_keys = getintarrfromstring(gen_keys[9]);
            intblock = XOR16(intblock, int_gen_keys); // конец зашифрования
            IV = arraysConcatForCBC(Arrays.copyOfRange(IV, 16, 24), intblock); // вставляю m-n бит в начало и шифротекст в конец
            n = Arrays.copyOf(IV, 16);
            for (int a : intblock) {
                byteList.add((byte) a);
            }
        }
        usedTime = (double) System.nanoTime() / 1000000000 - timeStart;
        byteList = byteList.subList(size * 16, byteList.size());
        byte[] tempByte = new byte[byteList.size()];
        for (int i = 0; i < byteList.size(); i++) {
            tempByte[i] = byteList.get(i);
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < tempByte.length; i++) {
            stringBuilder.append(tempByte[i]).append(" ");
            if (i % 16 == 0 && i != 0) {
                stringBuilder.append("\n");
            }
        }
        cipherTextAutocorrelation = ad * calculateCipherTextAutocorrelation(tempByte);
        cipherTextEntropy = calculateCipherTextEntropy(tempByte.length, "CBC");
        showMonitor();
        return stringBuilder.toString();
    }

    private String decryptCBC(String msg) { // расшифрование сообщения CBC
        int[] int_gen_keys;
        int[] IV = new int[]{63, 71, 110, 70, 36, 113, 52, 51, 209, 34, 182, 47, 88, 143, 201, 112, 55, 91, 168, 200, 14, 101, 235, 76};
        int[] n = Arrays.copyOf(IV, 16);
        List<Byte> byteList = new ArrayList<>();
        try (Scanner scanner = new Scanner(msg)) {
            while (scanner.hasNext()) {
                if (scanner.hasNextByte()) {
                    byteList.add(scanner.nextByte());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        double timeStart = (double) System.nanoTime() / 1000000000;
        int size = byteList.size() / 16;
        for (int c = 0; c < size; c++) {
            List<Byte> tempSubList = byteList.subList(c * 16, 16 * c + 16);
            if (c == size / 2 || c == size - 1) {
                monitor(1);
            }
            int[] intblock = new int[16];
            for (int i = 0; i < 16; i++) {
                intblock[i] = tempSubList.get(i);
            }
            for (int i = 0; i < intblock.length; i++) {
                if (intblock[i] >= 0) {
                    intblock[i] = tempSubList.get(i);
                } else {
                    intblock[i] = tempSubList.get(i) + 256;
                }
            }
            n = Arrays.copyOf(IV, 16);
            IV = arraysConcatForCBC(Arrays.copyOfRange(IV, 16, 24), intblock); // вставляю m-n бит в начало и шифротекст в конец

            for (int i = 9; i > 0; i--) { // начало расшифрования блока
                int_gen_keys = getintarrfromstring(gen_keys[i]);
                intblock = Reverse_S(Reverse_L(XOR16(intblock, int_gen_keys)));
            }
            int_gen_keys = getintarrfromstring(gen_keys[0]);
            intblock = XOR16(intblock, int_gen_keys); // конец расшифрования блока

            intblock = XOR16(n, intblock);


            for (int a : intblock) {
                byteList.add((byte) a);
            }
        }
        usedTime = (double) System.nanoTime() / 1000000000 - timeStart;
        byteList = byteList.subList(size * 16, byteList.size());
        byte[] tempByte = new byte[byteList.size()];
        for (int i = 0; i < byteList.size(); i++) {
            tempByte[i] = byteList.get(i);
        }
        int to;
        if (byteList.contains((byte) 20)) {
            to = byteList.indexOf((byte) 20);
        } else {
            to = size * 16;
        }
        tempByte = Arrays.copyOfRange(tempByte, 0, to);
        showMonitor();
        return new String(tempByte, StandardCharsets.UTF_8);
    }

    private String encryptMAC(String msg) { // зашифрование сообщения ЬФС
        double timeStart = (double) System.nanoTime() / 1000000000;
        byte[] tempByte = genMAC(msg);
        double ad = calculateCipherTextAutocorrelation(msg.getBytes(StandardCharsets.UTF_8));
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(encrypt(msg)).append(" ");
        for (int i = 0; i < tempByte.length; i++) {
            stringBuilder.append(tempByte[i]).append(" ");
            if (i % 16 == 0 && i != 0) {
                stringBuilder.append("\n");
            }
        }
        cipherTextAutocorrelation = ad * calculateCipherTextAutocorrelation(tempByte);
        cipherTextEntropy = calculateCipherTextEntropy(msg.length() + 8, "MAC");
        usedTime = (double) System.nanoTime() / 1000000000 - timeStart;
        showMonitor();
        return stringBuilder.toString();
    }

    private String decryptMAC(String msg) { // расшифрование сообщения MAC
        double timeStart = (double) System.nanoTime() / 1000000000;
        byte[] MACFrommsg = new byte[8];
        msg = msg.substring(0, msg.lastIndexOf(" "));
        for (int i = 7; i >= 0; i--) {
            MACFrommsg[i] = Byte.parseByte(msg.substring(msg.lastIndexOf(" ") + 1));
            msg = msg.substring(0, msg.lastIndexOf(" "));
        }
        msg = decrypt(msg);
        usedTime = (double) System.nanoTime() / 1000000000 - timeStart;
        if (Arrays.equals(genMAC(msg), MACFrommsg)) {
            return msg + "\nСообщение не подверглось изменениям";
        } else {
            return msg + "\nСообщение было изменено";
        }

    }
    public Interface() { // метод отвечающий за создание интерфейса и его работу
        encryptButton.addActionListener(e -> {
            String msg = textField1.getText();
            if (Perekl == 1) {
                textField2.setText(encrypt(msg));
            }
            if (Perekl == 2) {
                textField2.setText(encryptCTR(msg));
            }
            if (Perekl == 3) {
                textField2.setText(encryptOFB(msg));
            }
            if (Perekl == 4) {
                textField2.setText(encryptCBC(msg));
            }
            if (Perekl == 5) {
                textField2.setText(encryptCFB(msg));
            }
            if (Perekl == 6) {
                textField2.setText(encryptMAC(msg));
            }

        });
        decryptButton.addActionListener(e -> {
            String msg = textField2.getText();
            if (Perekl == 1) {
                textField3.setText(decrypt(msg));
            }
            if (Perekl == 2) {
                textField3.setText(decryptCTR(msg));
            }
            if (Perekl == 3) {
                textField3.setText(decryptOFB(msg));
            }
            if (Perekl == 4) {
                textField3.setText(decryptCBC(msg));
            }
            if (Perekl == 5) {
                textField3.setText(decryptCFB(msg));
            }
            if (Perekl == 6) {
                textField3.setText(decryptMAC(msg));
            }
        });
        encryptImageButton.addActionListener(e -> {
            if (PereklImage == 1) {
                encryptImage();
            }
            if (PereklImage == 2) {
                encryptImageCTR();
            }
            if (PereklImage == 3) {
                encryptImageOFB();
            }
            if (PereklImage == 4) {
                encryptImageCBC();
            }
            if (PereklImage == 5) {
                encryptImageCFB();
            }
            if (PereklImage == 6) {
                encryptImageMAC();
            }
        });
        decryptImageButton.addActionListener(e -> {
            if (PereklImage == 1) {
                decryptImage();
            }
            if (PereklImage == 2) {
                decryptImageCTR();
            }
            if (PereklImage == 3) {
                decryptImageOFB();
            }
            if (PereklImage == 4) {
                decryptImageCBC();
            }
            if (PereklImage == 5) {
                decryptImageCFB();
            }
            if (PereklImage == 6) {
                decryptImageMAC();
            }
        });
        loadImageToCipher.addActionListener(e -> {
            JFileChooser fileChooser = new JFileChooser();
            FileNameExtensionFilter filter = new FileNameExtensionFilter("Изображения", "jpg", "jpeg", "png", "bmp");
            fileChooser.setFileFilter(filter);
            int result = fileChooser.showOpenDialog(null);
            if (result == JFileChooser.APPROVE_OPTION) {
                try {
                    BufferedImage img = ImageIO.read(fileChooser.getSelectedFile());
                    imageCipher = img;
                    filePathCipher = fileChooser.getSelectedFile();
                    cipherImageFormat = fileChooser.getSelectedFile().getAbsolutePath().substring(fileChooser.getSelectedFile().getAbsolutePath().lastIndexOf("."));
                    imageToCipherLabel.setIcon(new ImageIcon(img.getScaledInstance(imageToCipherLabel.getWidth(), imageToCipherLabel.getHeight(), Image.SCALE_SMOOTH)));
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
        loadImageToDecipher.addActionListener(e -> {
            JFileChooser fileChooser = new JFileChooser();
            FileNameExtensionFilter filter = new FileNameExtensionFilter("Изображения", "jpg", "jpeg", "png", "bmp");
            fileChooser.setFileFilter(filter);
            int result = fileChooser.showOpenDialog(null);
            if (result == JFileChooser.APPROVE_OPTION) {
                try (FileInputStream fis = new FileInputStream(fileChooser.getSelectedFile().getAbsolutePath())) {
                    byte[] image = new byte[(int) fileChooser.getSelectedFile().length()];
                    fis.read(image);
                    BufferedImage img = createBufferedImageFromBytes(image, 400, 400);
                    decipherByteFile = image;
                    imageDecipher = img;
                    imageToDecipherLabel.setIcon(new ImageIcon(img.getScaledInstance(imageToCipherLabel.getWidth(), imageToCipherLabel.getHeight(), Image.SCALE_SMOOTH)));
                    cipherImageFormat = fileChooser.getSelectedFile().getAbsolutePath().substring(fileChooser.getSelectedFile().getAbsolutePath().lastIndexOf("."));
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
        saveCipheredImage.addActionListener(e -> {
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
            int result = fileChooser.showOpenDialog(null);
            if (result == JFileChooser.APPROVE_OPTION) {
                String str = fileChooser.getSelectedFile().getAbsolutePath() + "\\CipheredImage" + cipherImageFormat;
                try (FileOutputStream fos = new FileOutputStream(str)) {
                    fos.write(decipherByteFile);
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
        saveDecipheredImage.addActionListener(e -> {
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
            int result = fileChooser.showOpenDialog(null);
            if (result == JFileChooser.APPROVE_OPTION) {
                String str = fileChooser.getSelectedFile().getAbsolutePath() + "\\DecipheredImage" + cipherImageFormat;
                try (FileOutputStream fos = new FileOutputStream(str)) {
                    fos.write(decipheredByteFile);
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
        radioButton1.addActionListener(e -> {
            Perekl = 1;
            radioButton2.setSelected(false);
            radioButton3.setSelected(false);
            radioButton4.setSelected(false);
            radioButton5.setSelected(false);
            radioButton6.setSelected(false);
        });
        radioButton2.addActionListener(e -> {
            Perekl = 2;
            radioButton1.setSelected(false);
            radioButton3.setSelected(false);
            radioButton4.setSelected(false);
            radioButton5.setSelected(false);
            radioButton6.setSelected(false);
        });
        radioButton3.addActionListener(e -> {
            Perekl = 3;
            radioButton1.setSelected(false);
            radioButton2.setSelected(false);
            radioButton4.setSelected(false);
            radioButton5.setSelected(false);
            radioButton6.setSelected(false);
        });
        radioButton4.addActionListener(e -> {
            Perekl = 4;
            radioButton1.setSelected(false);
            radioButton2.setSelected(false);
            radioButton3.setSelected(false);
            radioButton5.setSelected(false);
            radioButton6.setSelected(false);
        });
        radioButton5.addActionListener(e -> {
            Perekl = 5;
            radioButton1.setSelected(false);
            radioButton2.setSelected(false);
            radioButton3.setSelected(false);
            radioButton4.setSelected(false);
            radioButton6.setSelected(false);
        });
        radioButton6.addActionListener(e -> {
            Perekl = 6;
            radioButton1.setSelected(false);
            radioButton2.setSelected(false);
            radioButton3.setSelected(false);
            radioButton4.setSelected(false);
            radioButton5.setSelected(false);
        });
        radioButton11.addActionListener(e -> {
            PereklImage = 1;
            radioButton22.setSelected(false);
            radioButton33.setSelected(false);
            radioButton44.setSelected(false);
            radioButton55.setSelected(false);
            radioButton66.setSelected(false);
        });
        radioButton22.addActionListener(e -> {
            PereklImage = 2;
            radioButton11.setSelected(false);
            radioButton33.setSelected(false);
            radioButton44.setSelected(false);
            radioButton55.setSelected(false);
            radioButton66.setSelected(false);
        });
        radioButton33.addActionListener(e -> {
            PereklImage = 3;
            radioButton11.setSelected(false);
            radioButton22.setSelected(false);
            radioButton44.setSelected(false);
            radioButton55.setSelected(false);
            radioButton66.setSelected(false);
        });
        radioButton44.addActionListener(e -> {
            PereklImage = 4;
            radioButton11.setSelected(false);
            radioButton22.setSelected(false);
            radioButton33.setSelected(false);
            radioButton55.setSelected(false);
            radioButton66.setSelected(false);
        });
        radioButton55.addActionListener(e -> {
            PereklImage = 5;
            radioButton11.setSelected(false);
            radioButton22.setSelected(false);
            radioButton33.setSelected(false);
            radioButton44.setSelected(false);
            radioButton66.setSelected(false);
        });
        radioButton66.addActionListener(e -> {
            PereklImage = 6;
            radioButton11.setSelected(false);
            radioButton22.setSelected(false);
            radioButton33.setSelected(false);
            radioButton44.setSelected(false);
            radioButton55.setSelected(false);
        });
    }


    public static void main(String[] args) { // Метод запуска приложения
        Interface anInterface = new Interface();
        anInterface.setContentPane(anInterface.mainPanel);
        anInterface.setTitle("Кузнечик");
        anInterface.setSize(1250, 600);

        anInterface.setVisible(true);
        anInterface.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gfpow2[0] = 1;
        gfpow2[1] = 2;
        gflog2[1] = 0;
        gflog2[2] = 1;

        for (int i = 2; i < 0xFF; i++) {
            gfpow2[i] = gfpow2[i - 1] * 2;
            if (gfpow2[i] > 255) {
                gfpow2[i] ^= 0x1c3;
            }
            gflog2[gfpow2[i]] = i;
        }
        gfpow2[0xFF] = 1;

        for (int i = 0; i < 32; i++) {
            C[i][0] = (i + 1);
            for (int r = 0; r < 15; r++) {
                C[i] = L(C[i]);
            }
        }
        gen_keys = gen_keys();
        getMACSubKeys();
    }
}

