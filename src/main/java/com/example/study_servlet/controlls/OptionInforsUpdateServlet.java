
import com.example.study_servlet.commons.Commons;
import com.example.study_servlet.daos.OptionInforsDao;

@WebServlet(urlPatterns = "/optionInforsUpdateServlet")
public class OptionInforsUpdateServlet extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            int count = 0;
            Commons commons = new Commons();
            String name = request.getParameter("name");

            OptionInforsDao optionInforsDao= new OptionInforsDao();
            count = optionInforsDao.OptionInforsUpdateServlet(name);
            
            response.setContentType("text/html;charset=UTF-8");
            PrintWriter printWriter = response.getWriter();
            String contents = "Update count :"+count;
            printWriter.println(contents);
            printWriter.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }