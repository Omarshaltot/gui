import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ExpenseTracker extends JFrame implements ActionListener {
    private Expense[] expenses;
    private int numberOfExpenses;
    private JTextArea expenseTextArea;
    private JTextField amountField;
    private JTextField categoryField;

    public ExpenseTracker() {
        expenses = new Expense[100]; // Initialize array to hold expenses (adjust size as needed)
        numberOfExpenses = 0; // Track the number of expenses added

        setTitle("Expense Tracker");
        setSize(400, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());

        expenseTextArea = new JTextArea(10, 20);
        JScrollPane scrollPane = new JScrollPane(expenseTextArea);
        panel.add(scrollPane, BorderLayout.CENTER);

        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new GridLayout(3, 2));
        inputPanel.add(new JLabel("Amount:"));
        amountField = new JTextField();
        inputPanel.add(amountField);
        inputPanel.add(new JLabel("Category:"));
        categoryField = new JTextField();
        inputPanel.add(categoryField);

        JButton addButton = new JButton("Add Expense");
        addButton.addActionListener(this); // Adding the ExpenseTracker instance as the ActionListener
        inputPanel.add(addButton);

        panel.add(inputPanel, BorderLayout.SOUTH);

        add(panel);
        setVisible(true);
    }

    private void addExpense() {
        try {
            double amount = Double.parseDouble(amountField.getText());
            String category = categoryField.getText();
            Expense expense = new Expense(amount, category);
            expenses[numberOfExpenses++] = expense; // Add expense to array
            updateExpenseTextArea();
            amountField.setText("");
            categoryField.setText("");
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Please enter a valid amount.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void updateExpenseTextArea() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < numberOfExpenses; i++) {
            Expense expense = expenses[i];
            sb.append("Category: ").append(expense.getCategory())
                    .append(", Amount: $").append(expense.getAmount())
                    .append("\n");
        }
        expenseTextArea.setText(sb.toString());
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Add Expense")) {
            addExpense();
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(ExpenseTracker::new);
    }

    private static class Expense {
        private double amount;
        private String category;

        public Expense(double amount, String category) {
            this.amount = amount;
            this.category = category;
        }

        public double getAmount() {
            return amount;
        }

        public String getCategory() {
            return category;
        }
    }
}
