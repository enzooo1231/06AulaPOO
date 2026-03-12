public class MonitorEnergia {
    double [] consumo;
    int indice;

    public MonitorEnergia(int tamanho) {
        this.consumo = new double[tamanho];
    }

    void registro(double valor){
        if (indice < consumo.length){
            consumo[indice] = valor;
            indice++;
        }

    }

    double calculaMedia(){
        double media =0;

        for (int i=0; i < indice; i++){
            media+=consumo[i];
        }
        return media/indice;
    }

    double calculaMedia(int inicio, int fim){

        double media =0;

        for (int i= inicio -1; i < fim; i++){
            media+=consumo[i];
        }
        return media/(fim - inicio);

    }


}
