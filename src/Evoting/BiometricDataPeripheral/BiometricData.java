package Evoting.BiometricDataPeripheral;

import Data.Nif;

public class BiometricData{
    private SingleBiometricData facialData;
    private SingleBiometricData fingerprintData;


    public BiometricData(SingleBiometricData facialData, SingleBiometricData fingerprintData){
        this.facialData=facialData;
        this.fingerprintData=fingerprintData;
    }

    public SingleBiometricData getFacialData(){
        return facialData;
    }

    public SingleBiometricData getFingerprintData(){
        return fingerprintData;
    }

    @Override
    public boolean equals (Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BiometricData bio = (BiometricData) o;
        return facialData.equals(bio.getFacialData()) && fingerprintData.equals(bio.getFingerprintData());
    }

}
