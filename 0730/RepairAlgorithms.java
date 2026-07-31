import java.util.ArrayList;

public class RepairAlgorithms {

    // Merge Sort
    public static void mergeSort(
            ArrayList<RepairTask> tasks,
            int left,
            int right) {

        if (left >= right) {
            return;
        }

        int mid = (left + right) / 2;

        mergeSort(tasks, left, mid);
        mergeSort(tasks, mid + 1, right);

        merge(tasks, left, mid, right);
    }

    private static void merge(
            ArrayList<RepairTask> tasks,
            int left,
            int mid,
            int right) {

        ArrayList<RepairTask> temp =
                new ArrayList<>();

        int i = left;
        int j = mid + 1;

        while (i <= mid && j <= right) {

            RepairTask a = tasks.get(i);
            RepairTask b = tasks.get(j);

            // 優先級高排前面
            if (a.getPriority() > b.getPriority()) {

                temp.add(a);
                i++;

            } else if (a.getPriority() < b.getPriority()) {

                temp.add(b);
                j++;

            } else {

                // 相同優先級保持登記順序
                if (a.getRegisterOrder()
                        < b.getRegisterOrder()) {

                    temp.add(a);
                    i++;

                } else {

                    temp.add(b);
                    j++;
                }
            }
        }

        while (i <= mid) {
            temp.add(tasks.get(i++));
        }

        while (j <= right) {
            temp.add(tasks.get(j++));
        }

        for (int k = 0; k < temp.size(); k++) {
            tasks.set(left + k, temp.get(k));
        }
    }

    // 設備名稱搜尋
    public static void searchByEquipment(
            ArrayList<RepairTask> tasks,
            String keyword) {

        boolean found = false;

        for (RepairTask task : tasks) {

            if (task.getEquipmentName()
                    .toLowerCase()
                    .contains(
                            keyword.toLowerCase())) {

                System.out.println(task);
                found = true;
            }
        }

        if (!found) {
            System.out.println("找不到資料");
        }
    }
}