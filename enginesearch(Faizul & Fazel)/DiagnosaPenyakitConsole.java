import java.util.*;

public class DiagnosaPenyakitConsole {

    private static final Map<String, String> penyakitMap = new HashMap<>();

    public static void main(String[] args) {
        // Data gejala → penyakit
        penyakitMap.put("demam,batuk kering,nyeri tenggorokan", "Influenza");
        penyakitMap.put("demam,batuk berdahak,sesak napas", "Pneumonia");
        penyakitMap.put("sakit kepala,mual,muntah,leher kaku", "Meningitis");

        Scanner scanner = new Scanner(System.in);

        System.out.println("=== Diagnosa Penyakit Berdasarkan Keluhan ===");
        System.out.print("Masukkan keluhan pasien: ");
        String keluhan = scanner.nextLine().toLowerCase();

        // Deteksi gejala
        List<String> gejalaTerdeteksi = new ArrayList<>();
        for (String gejala : getSemuaGejala()) {
            if (keluhan.contains(gejala)) {
                gejalaTerdeteksi.add(gejala);
            }
        }

        // Pencocokan penyakit
        String hasil = cariPenyakit(gejalaTerdeteksi);

        // Output
        System.out.println("\nGejala terdeteksi: " + gejalaTerdeteksi);
        System.out.println("Hasil Diagnosa: " + hasil);
    }

    private static Set<String> getSemuaGejala() {
        Set<String> allGejala = new HashSet<>();
        for (String key : penyakitMap.keySet()) {
            String[] gejala = key.split(",");
            Collections.addAll(allGejala, gejala);
        }
        return allGejala;
    }

    private static String cariPenyakit(List<String> gejalaUser) {
        for (Map.Entry<String, String> entry : penyakitMap.entrySet()) {
            List<String> ruleGejala = Arrays.asList(entry.getKey().split(","));
            if (gejalaUser.containsAll(ruleGejala)) {
                return "Kemungkinan penyakit: " + entry.getValue();
            }
        }
        return "Belum dapat dipastikan. Silakan konsultasi lebih lanjut.";
    }
}
