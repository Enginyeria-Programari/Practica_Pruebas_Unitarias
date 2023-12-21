package Evoting.BiometricDataPeripheral;

public class SingleBiometricData {

    private final byte[] biometricKey;

    public SingleBiometricData(byte[] biometricKey) {
        this.biometricKey = biometricKey.clone(); // Cloning to ensure immutability
    }

    public byte[] getBiometricKey() {
        return biometricKey.clone(); // Cloning to ensure immutability
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SingleBiometricData that = (SingleBiometricData) o;
        return java.util.Arrays.equals(biometricKey, that.biometricKey);
    }

    @Override
    public int hashCode() {
        return java.util.Arrays.hashCode(biometricKey);
    }

    @Override
    public String toString() {
        return "SingleBiometricData{" +
                "biometricKey=" + java.util.Arrays.toString(biometricKey) +
                '}';
    }
}
