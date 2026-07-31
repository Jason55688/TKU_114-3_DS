public class RepairTask {

    private String taskId;
    private String equipmentName;
    private int priority;
    private int registerOrder;

    public RepairTask(String taskId,
                      String equipmentName,
                      int priority,
                      int registerOrder) {

        this.taskId = taskId;
        this.equipmentName = equipmentName;
        this.priority = priority;
        this.registerOrder = registerOrder;
    }

    public String getTaskId() {
        return taskId;
    }

    public String getEquipmentName() {
        return equipmentName;
    }

    public int getPriority() {
        return priority;
    }

    public int getRegisterOrder() {
        return registerOrder;
    }

    @Override
    public String toString() {

        return taskId + " | "
                + equipmentName + " | Priority="
                + priority + " | Order="
                + registerOrder;
    }
}