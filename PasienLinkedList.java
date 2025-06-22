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

    public void add(Pasien p) {
        PasienNode baru = new PasienNode(p, null);
        if (head == null) {
            head = baru;
            tail = baru;
        } else {
            tail.next = baru;
            tail = baru;
        }
        size++;
        System.out.println("Pasien \"" + p.nama + "\" berhasil ditambahkan ke antrian.");
    }

    public Pasien layani() {
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

    public void displayAntrian() {
        if (isEmpty()) {
            System.out.println("Antrian kosong, tidak ada pasien.");
            return;
        }
        System.out.println("=== DAFTAR PASIEN DALAM ANTRIAN ===");
        PasienNode curr = head;
        while (curr != null) {
            curr.data.tampil();
            curr = curr.next;
        }
    }
}
