import java.util.ArrayList;

public class RegistrationAlgorithms {

    // Merge Sort
    public static void mergeSort(
            ArrayList<Registration> list,
            int left,
            int right) {

        if (left >= right) {
            return;
        }

        int mid = (left + right) / 2;

        mergeSort(list, left, mid);
        mergeSort(list, mid + 1, right);

        merge(list, left, mid, right);
    }

    private static void merge(
            ArrayList<Registration> list,
            int left,
            int mid,
            int right) {

        ArrayList<Registration> temp =
                new ArrayList<>();

        int i = left;
        int j = mid + 1;

        while (i <= mid && j <= right) {

            if (list.get(i).getRegistrationId()
                    .compareTo(list.get(j).getRegistrationId()) <= 0) {

                temp.add(list.get(i++));
            } else {
                temp.add(list.get(j++));
            }
        }

        while (i <= mid) {
            temp.add(list.get(i++));
        }

        while (j <= right) {
            temp.add(list.get(j++));
        }

        for (int k = 0; k < temp.size(); k++) {
            list.set(left + k, temp.get(k));
        }
    }

    // Binary Search
    public static int binarySearch(
            ArrayList<Registration> list,
            String targetId) {

        int low = 0;
        int high = list.size() - 1;

        while (low <= high) {

            int mid = (low + high) / 2;

            int result =
                    list.get(mid)
                            .getRegistrationId()
                            .compareTo(targetId);

            if (result == 0) {
                return mid;
            }

            if (result > 0) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return -1;
    }

    // Sequential Search
    public static void searchByName(
            ArrayList<Registration> list,
            String name) {

        boolean found = false;

        for (Registration r : list) {

            if (r.getName()
                 .equalsIgnoreCase(name)) {

                System.out.println(r);
                found = true;
            }
        }

        if (!found) {
            System.out.println("找不到資料");
        }
    }

    // 編號重複檢查
    public static boolean isDuplicateId(
            ArrayList<Registration> list,
            String id) {

        for (Registration r : list) {

            if (r.getRegistrationId()
                 .equalsIgnoreCase(id)) {

                return true;
            }
        }

        return false;
    }
}