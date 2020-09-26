package com.canton.service.impl;

import com.canton.dao.entity.Book;
import com.canton.service.BookService;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @Auther ChenX
 * @Date 2020.8.9
 **/
@Service
public class BookServiceImpl implements BookService {
    @Override
    public List<Book> getAllBook() {
        List<Book> list = new ArrayList();
        File directory = new File("src/main/resources");
        String path = null;
        try {
            path = directory.getCanonicalPath();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            File file = new File(path+"/book");
            String[] filelist = file.list();
            for (int i = 0; i < filelist.length; i++) {
                Book book = new Book();
                book.setId(i+1);
                book.setTitle(filelist[i].substring(0, filelist[i].lastIndexOf(".")));
                list.add(book);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public String getBook() {
        return null;
    }

    @Override
    public String deleteBook(String book) {
        File directory = new File("src/main/resources");
        String path = null;
        try {
            path = directory.getCanonicalPath();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            File file = new File(path+"/book/"+book+".txt");
            if( file.exists()==true){
                file.delete();
                return "删除成功";
            }
            else{
                return "删除失败";
            }

        } catch (Exception e) {
            e.printStackTrace();
            return "删除失败";
        }
    }


}
