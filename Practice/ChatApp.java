import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class ChatApp extends JFrame {
    private JTextArea chatArea;
    private JTextField messageField;
    private JButton sendButton;
    private JList<String> contactsList;
    private DefaultListModel<String> contactsModel;

    public ChatApp() {
        setTitle("Chat Application");
        setSize(720,620);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Chat area
        chatArea = new JTextArea();
        chatArea.setEditable(false);
        JScrollPane chatScroll = new JScrollPane(chatArea);
        add(chatScroll, BorderLayout.CENTER);

        // Message input field
        JPanel inputPanel = new JPanel(new BorderLayout());
        messageField = new JTextField();
        sendButton = new JButton("Send");
        sendButton.addActionListener(e -> sendMessage());
        inputPanel.add(messageField, BorderLayout.CENTER);
        inputPanel.add(sendButton, BorderLayout.EAST);
        add(inputPanel, BorderLayout.SOUTH);

        // Contacts list
        JPanel contactsPanel = new JPanel(new BorderLayout());
        contactsModel = new DefaultListModel<>();
        contactsList = new JList<>(contactsModel);
        JScrollPane contactsScroll = new JScrollPane(contactsList);
        contactsPanel.add(new JLabel("Contacts"), BorderLayout.NORTH);
        contactsPanel.add(contactsScroll, BorderLayout.CENTER);

        // Contacts management buttons
        JPanel contactsButtons = new JPanel(new FlowLayout());
        JButton addContactButton = new JButton("Add Contact");
        addContactButton.addActionListener(e -> addContact());
        JButton removeContactButton = new JButton("Remove Contact");
        removeContactButton.addActionListener(e -> removeContact());
        contactsButtons.add(addContactButton);
        contactsButtons.add(removeContactButton);
        contactsPanel.add(contactsButtons, BorderLayout.SOUTH);

        add(contactsPanel, BorderLayout.WEST);

        setVisible(true);
    }

    // Send message
    private void sendMessage() {
        String message = messageField.getText();
        if (!message.isEmpty()) {
            String selectedContact = contactsList.getSelectedValue();
            if (selectedContact != null) {
                chatArea.append("You to " + selectedContact + ": " + message + "\n");
                messageField.setText("");
            } else {
                JOptionPane.showMessageDialog(this, "Please select a contact to send the message.");
            }
        }
    }

    // Add new contact
    private void addContact() {
        String contactName = JOptionPane.showInputDialog(this, "Enter Contact Name:");
        String phoneNumber = JOptionPane.showInputDialog(this, "Enter Contact Phone Number : ");
        if (contactName != null && !contactName.trim().isEmpty()) {
            contactsModel.addElement(contactName.trim());
        }
    }

    // Remove selected contact
    private void removeContact() {
        String selectedContact = contactsList.getSelectedValue();
        if (selectedContact != null) {
            contactsModel.removeElement(selectedContact);
        } else {
            JOptionPane.showMessageDialog(this, "Please select a contact to remove.");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(ChatApp::new);
    }
}
