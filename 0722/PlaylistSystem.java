import java.util.Scanner;

public class PlaylistSystem {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        PlaylistLinkedList playlist =
                new PlaylistLinkedList();

        // 預設歌曲
        playlist.addSong("S001", "Yesterday");
        playlist.addSong("S002", "Hello");
        playlist.addSong("S003", "Shape of You");

        int option;

        do {

            System.out.println("\n=== Playlist Menu ===");
            System.out.println("1. 新增歌曲");
            System.out.println("2. 搜尋歌曲");
            System.out.println("3. 刪除歌曲");
            System.out.println("4. 顯示播放清單");
            System.out.println("0. 離開");
            System.out.print("請輸入選項：");

            option = sc.nextInt();
            sc.nextLine();

            switch (option) {

                case 1:

                    System.out.print("歌曲代碼：");
                    String id = sc.nextLine();

                    System.out.print("歌曲名稱：");
                    String name = sc.nextLine();

                    playlist.addSong(id, name);

                    System.out.println("新增成功！");
                    break;

                case 2:

                    System.out.print("搜尋代碼：");
                    String searchId = sc.nextLine();

                    PlaylistNode song =
                            playlist.searchSong(searchId);

                    if (song != null) {
                        System.out.println(
                                "找到："
                                + song.songId
                                + " - "
                                + song.songName);
                    } else {
                        System.out.println("找不到歌曲");
                    }

                    break;

                case 3:

                    System.out.print("刪除代碼：");
                    String removeId = sc.nextLine();

                    if (playlist.removeSong(removeId)) {
                        System.out.println("刪除成功");
                    } else {
                        System.out.println("找不到歌曲");
                    }

                    break;

                case 4:

                    playlist.displayPlaylist();
                    break;

                case 0:

                    System.out.println("程式結束");
                    break;

                default:

                    System.out.println("無效選項");
            }

        } while (option != 0);

        sc.close();
    }
}