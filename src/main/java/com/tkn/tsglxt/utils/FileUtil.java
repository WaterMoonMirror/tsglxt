package com.tkn.tsglxt.utils;

import com.google.common.collect.Lists;
import com.tkn.tsglxt.enums.FileEnum;
import com.tkn.tsglxt.exception.FileException;
import com.tkn.tsglxt.vo.FileVo;
import org.apache.commons.lang3.StringUtils;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 *  文件工具类
 */
public class FileUtil {


    /**
     *  获取File文件对象
     * @param url
     * @return
     */
    public static File getFile(String url){
        if (StringUtils.isBlank(url)) {
           throw  new FileException(FileEnum.BLANK_URL.getValue());
        }
        File file=new File(url);
        return file;
    }

    /**
     * 获取 FileVo对象
     * @param url
     * @return
     */
    public static FileVo getFileVol(String url){
        File f = getFile(url);
        FileVo fileVo1 = FileVo.builder().fileName(f.getName()).filePath(f.getPath()).build();
        return fileVo1;
    }

    public static List<FileVo> getFileVos(File file,List<FileVo> fileVos){
        if (!file.exists())
            throw new FileException(FileEnum.FILE_NO_EXISTS.getValue());
        String fileName = file.getName();
        File[] files = file.listFiles();
        if (files == null) {
            return fileVos;
        }
        for (File f :
                files) {
            fileVos.add(FileVo.builder().fileName(f.getName()).filePath(f.getPath()).build());
            if (f.isDirectory())
                getFileVos(f,fileVos);
        }
        return fileVos;
    }

    public static FileVo getTreeFileVos(File file,FileVo fileVo){
        if (!file.exists())
            throw new FileException(FileEnum.FILE_NO_EXISTS.getValue());
        File[] files = file.listFiles();
        List<FileVo> fileVos= Lists.newArrayList();
        if (files == null) {
            return fileVo;
        }
        for (File f :
                files) {
            FileVo fileVo1 = FileVo.builder().fileName(f.getName()).filePath(f.getPath()).level(fileVo.getLevel()+1).build();
            fileVos.add(fileVo1);
            if (f.isDirectory())
                getTreeFileVos(f,fileVo1);
        }
        fileVo.setFileVos(fileVos);
        return fileVo;
    }

    public static FileVo getTreeFileVos(String url){
        File file = getFile(url);
        FileVo fileVo = getFileVol(url);
        return  getTreeFileVos(file,fileVo);
    }

    public static void main(String[] args) {
        try
        {
            File file=new File("E:\\书签\\bookmarks_2018_9_21.html"); //源文件
            if (file.renameTo(new File("E:\\书签\\bookmarks_2018_9_21\\"+file.getName()))) //源文件移动至目标文件目录
            {
                System.out.println("File is moved successful!");//输出移动成功
            }
            else
            {
                System.out.println("File is failed to move !");//输出移动失败
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    public static void showTree(FileVo fileVo){
        System.out.println("fileVo = " + fileVo);
        fileVo.getFileVos().forEach(f->{
            System.out.println("fileVo = " + f);
            if (f.getFileVos()!=null) {
                showTree(f);
            }
        });
    }

    /**
     *   移动文件
     * @return
     */
    public static boolean moveFile(FileVo file,String oldPath,String newPath){
        /**
         *  1.获取旧的地址下的所有文件
         *  2. 循环地址下的文件，是否有重复文件，如果有重名文件，添加序号
         */
        File oldpathFile = getFile(newPath);
        File newpathFile = getFile(newPath);
        // 判断是否为文件夹
        if (!newpathFile.isDirectory())
            throw  new FileException(FileEnum.PATH_NO_DIR.getValue());
        // 获取文件夹下的所有文件



        return  true;
    }


}
