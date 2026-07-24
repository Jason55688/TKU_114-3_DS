public class PlaylistLinkedList {

    private PlaylistNode head;

    // 尾端新增
    public void addSong(String id, String name) {

        PlaylistNode newNode =
                new PlaylistNode(id, name);

        if (head == null) {
            head = newNode;
            return;
        }

        PlaylistNode current = head;

        while (current.next != null) {
            current = current.next;
        }

        current.next = newNode;
    }

    // 依代碼搜尋
    public PlaylistNode searchSong(String id) {

        PlaylistNode current = head;

        while (current != null) {

            if (current.songId.equalsIgnoreCase(id)) {
                return current;
            }

            current = current.next;
        }

        return null;
    }

    // 刪除歌曲
    public boolean removeSong(String id) {

        if (head == null) {
            return false;
        }

        // 刪除第一首
        if (head.songId.equalsIgnoreCase(id)) {
            head = head.next;
            return true;
        }

        PlaylistNode current = head;

        while (current.next != null) {

            if (current.next.songId.equalsIgnoreCase(id)) {

                current.next = current.next.next;
                return true;
            }

            current = current.next;
        }

        return false;
    }

    // 輸出播放順序
    public void displayPlaylist() {

        if (head == null) {
            System.out.println("播放清單為空");
            return;
        }

        PlaylistNode current = head;

        while (current != null) {

            System.out.println(
                    current.songId
                    + " - "
                    + current.songName);

            current = current.next;
        }
    }
}