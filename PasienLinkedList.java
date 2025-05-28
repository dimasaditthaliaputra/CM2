// Pranata Putrandana
public class PasienLinkedList {
    PasienNode head;
    PasienNode tail;
    int size;

    public PasienLinkedList() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    // Menambah pasien di akhir antrian (enqueue)
    public void enqueue(Pasien p) {
        PasienNode baru = new PasienNode(p);
        if (head == null) {
            head = baru;
            tail = baru;
        } else {
            tail.next = baru;
            tail = baru;
        }
        size++;
        System.out.println("  >> Pasien \"" + p.nama + "\" berhasil ditambahkan ke antrian.");
    }

    // Mengambil pasien di depan antrian (dequeue)
    public Pasien dequeue() {
        if (isEmpty()) {
            return null;
        }
        PasienNode keluar = head;
        head = head.next;
        if (head == null) {
            tail = null;
        }
        size--;
        return keluar.data;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public int getSize() {
        return size;
    }

    // Menampilkan semua pasien yang sedang antre
    public void displayAntrian() {
        if (isEmpty()) {
            System.out.println("  >> Antrian kosong, tidak ada pasien.");
            return;
        }
        System.out.println("  === DAFTAR PASIEN DALAM ANTRIAN ===");
        PasienNode curr = head;
        int no = 1;
        while (curr != null) {
            System.out.println("  #" + no);
            curr.data.tampil();
            System.out.println("----------------------------");
            curr = curr.next;
            no++;
        }
    }
}
