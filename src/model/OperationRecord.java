package model;

public class OperationRecord {
    private final OperationType type;
    private final double amount;
    private final String description;

    public OperationRecord(OperationType type, double amount, String description) {
        this.type = type;
        this.amount = amount;
        this.description = description;
    }

    public OperationType getType() {
        return type;
    }

    public double getAmount() {
        return amount;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return "OperationRecord{" +
                "type=" + type +
                ", amount=" + amount +
                ", description='" + description + '\'' +
                '}';
    }
}
