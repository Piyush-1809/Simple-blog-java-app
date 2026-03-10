import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

class BlogPost{
    private String title;
    private String content;

    public BlogPost(String title,String content){
        this.title=title;
        this.content=content;
    }

    public String getTitle(){return title;}
    public String getContent(){return content;}
}

public class MyBlogApp{

    private ArrayList<BlogPost> posts=new ArrayList<>();
    private JFrame mainFrame;

    public MyBlogApp(){
        mainFrame=new JFrame("Simple Blog App");
        mainFrame.setSize(400,300);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel=new JPanel(new GridLayout(3,1));

        JButton createBtn=new JButton("Create Blog");
        JButton viewBtn=new JButton("View Blogs");
        JButton exitBtn=new JButton("Exit");

        createBtn.addActionListener(e->openCreateBlog());
        viewBtn.addActionListener(e->openViewBlogs());
        exitBtn.addActionListener(e->System.exit(0));

        panel.add(createBtn);
        panel.add(viewBtn);
        panel.add(exitBtn);

        mainFrame.add(panel);
    }

    private void openCreateBlog(){
        JFrame frame=new JFrame("Create Blog");
        frame.setSize(400,300);

        JTextField title=new JTextField();
        JTextArea content=new JTextArea();
        JButton submit=new JButton("Submit");

        submit.addActionListener(e->{
            if(!title.getText().isEmpty() && !content.getText().isEmpty()){
                posts.add(new BlogPost(title.getText(),content.getText()));
                JOptionPane.showMessageDialog(frame,"Blog Created");
                frame.dispose();
            }
        });

        frame.setLayout(new BorderLayout());
        frame.add(title,BorderLayout.NORTH);
        frame.add(new JScrollPane(content),BorderLayout.CENTER);
        frame.add(submit,BorderLayout.SOUTH);

        frame.setVisible(true);
    }

    private void openViewBlogs(){
        JFrame frame=new JFrame("All Blogs");
        frame.setSize(400,300);

        JTextArea area=new JTextArea();
        area.setEditable(false);

        for(BlogPost p:posts){
            area.append("Title: "+p.getTitle()+"\n");
            area.append(p.getContent()+"\n\n");
        }

        frame.add(new JScrollPane(area));
        frame.setVisible(true);
    }

    public void run(){
        mainFrame.setVisible(true);
    }

    public static void main(String[] args){
        new MyBlogApp().run();
    }
}
