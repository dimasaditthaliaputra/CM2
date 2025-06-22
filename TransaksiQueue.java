// Dimas Adit Thalia Putra / 06
public class TransaksiQueue {
    TransaksiLayanan[] data;
    int front;
    int rear;
    int size;
    int max;

    public TransaksiQueue(int max) {
        data = new TransaksiLayanan[max];
        front = rear = size = 0;
        this.max = max; 
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == max;
    }    

    public void enqueue(TransaksiLayanan dataTransaksi) {
        if (isFull()) {
            System.out.println("Antrian sudah penuh!");
            return;
        }

        if (isEmpty()) {
            front = rear = 0;
        } else {
            if (rear == max - 1) {
                rear = 0;
            } else {
                rear++;
            }
        }
        data[rear] = dataTransaksi;
        size++;
        System.out.println("Berhasil Melayani Pasien");
        dataTransaksi.tampil();
    }

    public void getRiwayat() {
        if (isEmpty()) {
            System.out.println("Tidak ada antrian.");
            return;
        }
    
        System.out.println("Riwayat Transaksi Layanan:");
    
        int i = front;
        int count = 1;
    
        while (true) {
            System.out.println("Transaksi ke-" + count + ":");
            data[i].tampil();
            System.out.println();
    
            if (i == rear) break;
    
            i = (i + 1) % max;
            count++;
        }
    }    
}
