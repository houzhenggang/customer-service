/**
 * 文件型工具类文件
 *
 * @title: FileUtil.java
 * @author 邢治理
 * @date 2016年2月24日 下午3:10:52
 */
package com.hshc.kfpub.comm;

import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.math.BigInteger;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.zip.Checksum;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.LineIterator;
import org.apache.commons.io.filefilter.IOFileFilter;

/**
 * 字符型工具类，方法出现顺序规则：以方法名字母排序
 * 
 * @className FileUtil
 * @author 邢治理
 * @version V1.0 2016年3月3日17:36:10
 */
final class FileUtil {

    /**
     * 按照字符串数组中的名称，从指定的目录中获取文件
     * 
     * @param directory
     * @param names
     * @return File
     */
    public File getFile(File directory, String[] names) {
        return FileUtils.getFile(directory, names);
    }

    /**
     * 按照字符串数组中的名称获取文件
     * 
     * @param names
     * @return File
     */
    public File getFile(String[] names) {
        return FileUtils.getFile(names);
    }

    /**
     * 获取系统的临时目录路径
     * 
     * @return String
     */
    public String getTempDirectoryPath() {
        return FileUtils.getTempDirectoryPath();
    }

    /**
     * 获取代表系统临时目录的文件
     * 
     * @return File
     */
    public File getTempDirectory() {
        return FileUtils.getTempDirectory();
    }

    /**
     * 获取用户的主目录路径
     * 
     * @return String
     */
    public String getUserDirectoryPath() {
        return FileUtils.getUserDirectoryPath();
    }

    /**
     * 获取代表用户主目录的文件
     * 
     * @return File
     */
    public File getUserDirectory() {
        return FileUtils.getUserDirectory();
    }

    /**
     * 根据指定的文件获取一个新的文件输入流
     * 
     * @param file
     * @return FileInputStream
     */
    public FileInputStream openInputStream(File file) {
        try {
            return FileUtils.openInputStream(file);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 根据指定的文件获取一个新的文件输出流
     * 
     * @param file
     * @return FileOutputStream
     */
    public FileOutputStream openOutputStream(File file) {
        try {
            return FileUtils.openOutputStream(file);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 创建一个向指定 File 对象表示的文件中写入数据的文件输出流。如果第二个参数为 true，则将字节写入文件末尾处，而不是写入文件开始处。
     * 
     * @param file
     * @param append
     * @return FileOutputStream
     */
    public FileOutputStream openOutputStream(File file, boolean append) {
        try {
            return FileUtils.openOutputStream(file, append);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 字节转换成直观带单位的值（包括单位GB，MB，KB或字节）
     * 
     * @param size
     * @return String
     */
    public String byteCountToDisplaySize(BigInteger size) {
        return FileUtils.byteCountToDisplaySize(size);
    }

    /**
     * 字节转换成直观的，带单位的值（包括单位GB，MB，KB或字节）
     * 
     * @param size
     * @return String
     */
    public String byteCountToDisplaySize(long size) {
        return FileUtils.byteCountToDisplaySize(size);
    }

    /**
     * 创建一个空文件，若文件应经存在则只更改文件的最近修改时间
     * 
     * @param file
     * @throws IOException
     */
    public void touch(File file) throws IOException {
        FileUtils.touch(file);
    }

    /**
     * 把相应的文件集合转换成文件数组
     * 
     * @param files
     * @return File[]
     */
    public File[] convertFileCollectionToFileArray(Collection<File> files) {
        return FileUtils.convertFileCollectionToFileArray(files);
    }

    /**
     * 根据一个IOFileFilter过滤规则获取一个目录下的文件集合
     * 
     * @param directory
     * @param fileFilter
     * @param dirFilter
     * @return Collection<File>
     */
    public Collection<File> listFiles(File directory, IOFileFilter fileFilter, IOFileFilter dirFilter) {
        return FileUtils.listFiles(directory, fileFilter, dirFilter);
    }

    /**
     * 根据一个IOFileFilter过滤规则获取一个目录下的文件集合的Iterator迭代器
     * 
     * @param directory
     * @param fileFilter
     * @param dirFilter
     * @return Iterator<File>
     */
    public Iterator<File> iterateFiles(File directory, IOFileFilter fileFilter, IOFileFilter dirFilter) {
        return FileUtils.iterateFiles(directory, fileFilter, dirFilter);
    }

    /**
     * 查找一个目录下面符合对应扩展名的文件的集合
     * 
     * @param directory
     * @param extensions
     * @param recursive
     * @return Collection<File>
     */
    public Collection<File> listFiles(File directory, String[] extensions, boolean recursive) {
        return FileUtils.listFiles(directory, extensions, recursive);
    }

    /**
     * 查找一个目录下面符合对应扩展名的文件的集合的迭代器
     * 
     * @param directory
     * @param extensions
     * @param recursive
     * @return Iterator<File>
     */
    public Iterator<File> iterateFiles(File directory, String[] extensions, boolean recursive) {
        return FileUtils.iterateFiles(directory, extensions, recursive);
    }

    /**
     * 判断两个文件是否相等
     * 
     * @param file1
     * @param file2
     * @return boolean
     * @throws IOException
     */
    public boolean contentEquals(File file1, File file2) throws IOException {
        return FileUtils.contentEquals(file1, file2);
    }

    /**
     * Compares the contents of two files to determine if they are equal or not.This method checks to see if the two files point to the same file,
     * before resorting to line-by-line comparison of the contents.
     * 
     * @param file1
     * @param file2
     * @param charsetName
     * @return boolean
     * @throws IOException
     */
    public boolean contentEqualsIgnoreEOL(File file1, File file2, String charsetName) {
        try {
            return FileUtils.contentEqualsIgnoreEOL(file1, file2, charsetName);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 根据一个Url来创建一个文件
     * 
     * @param url
     * @return File
     */
    public File toFile(URL url) {
        return FileUtils.toFile(url);
    }

    /**
     * 将一个URL数组转化成一个文件数组
     * 
     * @param urls
     * @return
     */
    public File[] toFiles(URL[] urls) {
        return FileUtils.toFiles(urls);
    }

    /**
     * 将一个文件数组转化成一个URL数组
     * 
     * @param files
     * @return URL[]
     */
    public URL[] toURLs(File[] files) {
        try {
            return FileUtils.toURLs(files);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 拷贝一个文件到指定的目录文件
     * 
     * @param srcFile
     * @param destDir
     */
    public void copyFileToDirectory(File srcFile, File destDir) {
        try {
            FileUtils.copyFileToDirectory(srcFile, destDir);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 拷贝一个文件到指定的目录文件并且设置是否更新文件的最近修改时间
     * 
     * @param srcFile
     * @param destDir
     * @param preserveFileDate
     */
    public void copyFileToDirectory(File srcFile, File destDir, boolean preserveFileDate) {
        try {
            FileUtils.copyFileToDirectory(srcFile, destDir, preserveFileDate);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 拷贝文件到新的文件中并且保存最近修改时间
     * 
     * @param srcFile
     * @param destFile
     */
    public void copyFile(File srcFile, File destFile) {
        try {
            FileUtils.copyFile(srcFile, destFile);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 拷贝文件到新的文件中并且设置是否保存最近修改时间
     * 
     * @param srcFile
     * @param destFile
     * @param preserveFileDate
     */
    public void copyFile(File srcFile, File destFile, boolean preserveFileDate) {
        try {
            FileUtils.copyFile(srcFile, destFile, preserveFileDate);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 
     * @param input
     * @param output
     * @return long
     */
    public long copyFile(File input, OutputStream output) {
        try {
            return FileUtils.copyFile(input, output);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 将一个目录拷贝到另一目录中，并且保存最近更新时间
     * 
     * @param srcDir
     * @param destDir
     */
    public void copyDirectoryToDirectory(File srcDir, File destDir) {
        try {
            FileUtils.copyDirectoryToDirectory(srcDir, destDir);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 拷贝整个目录到新的位置，并且保存最近修改时间
     * 
     * @param srcDir
     * @param destDir
     * @throws IOException
     */
    public void copyDirectory(File srcDir, File destDir) throws IOException {
        FileUtils.copyDirectory(srcDir, destDir);
    }

    /**
     * 拷贝整个目录到新的位置，并且设置是否保存最近修改时间
     * 
     * @param srcDir
     * @param destDir
     * @param preserveFileDate
     * @throws IOException
     */
    public void copyDirectory(File srcDir, File destDir, boolean preserveFileDate) throws IOException {
        FileUtils.copyDirectory(srcDir, destDir, preserveFileDate);
    }

    /**
     * 拷贝过滤后的目录到指定的位置，并且保存最近修改时间
     * 
     * @param srcDir
     * @param destDir
     * @param filter
     * @throws IOException
     */
    public void copyDirectory(File srcDir, File destDir, FileFilter filter) throws IOException {
        FileUtils.copyDirectory(srcDir, destDir, filter);
    }

    /**
     * 拷贝过滤后的目录到指定的位置，并且设置是否保存最近修改时间
     * 
     * @param srcDir
     * @param destDir
     * @param filter
     * @param preserveFileDate
     * @throws IOException
     */
    public void copyDirectory(File srcDir, File destDir, FileFilter filter, boolean preserveFileDate) throws IOException {
        FileUtils.copyDirectory(srcDir, destDir, filter, preserveFileDate);
    }

    /**
     * 根据一个Url拷贝字节到一个文件中
     * 
     * @param source
     * @param destination
     * @throws IOException
     */
    public void copyURLToFile(URL source, File destination) throws IOException {
        FileUtils.copyURLToFile(source, destination);
    }

    /**
     * 根据一个Url拷贝字节到一个文件中，并且可以设置连接的超时时间和读取的超时时间
     * 
     * @param source
     * @param destination
     * @param connectionTimeout
     * @param readTimeout
     * @throws IOException
     */
    public void copyURLToFile(URL source, File destination, int connectionTimeout, int readTimeout) throws IOException {
        FileUtils.copyURLToFile(source, destination, connectionTimeout, readTimeout);
    }

    /**
     * 拷贝一个字节流到一个文件中，如果这个文件不存在则新创建一个，存在的话将被重写进内容
     * 
     * @param source
     * @param destination
     * @throws IOException
     */
    public void copyInputStreamToFile(InputStream source, File destination) throws IOException {
        FileUtils.copyInputStreamToFile(source, destination);
    }

    /**
     * 递归的删除一个目录
     * 
     * @param directory
     * @throws IOException
     */
    public void deleteDirectory(File directory) throws IOException {
        FileUtils.deleteDirectory(directory);
    }

    /**
     * 安静模式删除目录，操作过程中会抛出异常
     * 
     * @param file
     * @return boolean
     */
    public boolean deleteQuietly(File file) {
        return FileUtils.deleteQuietly(file);
    }

    /**
     * 
     * @param directory
     * @param child
     * @return boolean
     * @throws IOException
     */
    public boolean directoryContains(File directory, File child) throws IOException {
        return FileUtils.directoryContains(directory, child);
    }

    /**
     * 清除一个目录而不删除它
     * 
     * @param directory
     * @throws IOException
     */
    public void cleanDirectory(File directory) throws IOException {
        FileUtils.cleanDirectory(directory);
    }

    /**
     * 等待NFS来传播一个文件的创建，实施超时
     * 
     * @param file
     * @param seconds
     * @return boolean
     */
    public boolean waitFor(File file, int seconds) {
        return FileUtils.waitFor(file, seconds);
    }

    /**
     * 
     * @param file
     * @param encoding
     * @return String
     * @throws IOException
     */
    public String readFileToString(File file, Charset encoding) throws IOException {
        return FileUtils.readFileToString(file, encoding);
    }

    /**
     * 把一个文件的内容读取到一个对应编码的字符串中去
     * 
     * @param file
     * @param encoding
     * @return String
     * @throws IOException
     */
    public String readFileToString(File file, String encoding) throws IOException {
        return FileUtils.readFileToString(file, encoding);
    }

    /**
     * 读取文件的内容到虚拟机的默认编码字符串
     * 
     * @param file
     * @return String
     * @throws IOException
     */
    public String readFileToString(File file) throws IOException {
        return FileUtils.readFileToString(file);
    }

    /**
     * 
     * @param file
     * @return byte[]
     * @throws IOException
     */
    public byte[] readFileToByteArray(File file) throws IOException {
        return FileUtils.readFileToByteArray(file);
    }

    /**
     * 
     * @param file
     * @param encoding
     * @return List<String>
     * @throws IOException
     */
    public List<String> readLines(File file, Charset encoding) throws IOException {
        return FileUtils.readLines(file, encoding);
    }

    /**
     * 把文件中的内容逐行的拷贝到一个对应编码的list<String>中去
     * 
     * @param file
     * @param encoding
     * @return List<String>
     * @throws IOException
     */
    public List<String> readLines(File file, String encoding) throws IOException {
        return FileUtils.readLines(file, encoding);
    }

    /**
     * 把文件中的内容逐行的拷贝到一个虚拟机默认编码的list<String>中去
     * 
     * @param file
     * @return List<String>
     * @throws IOException
     */
    public List<String> readLines(File file) throws IOException {
        return FileUtils.readLines(file);
    }

    /**
     * 根据对应编码返回对应文件内容的行迭代器
     * 
     * @param file
     * @param encoding
     * @return LineIterator
     * @throws IOException
     */
    public LineIterator lineIterator(File file, String encoding) throws IOException {
        return FileUtils.lineIterator(file, encoding);
    }

    /**
     * 根据虚拟机默认编码返回对应文件内容的行迭代器
     * 
     * @param file
     * @return LineIterator
     * @throws IOException
     */
    public LineIterator lineIterator(File file) throws IOException {
        return FileUtils.lineIterator(file);
    }

    /**
     * 
     * @param file
     * @param data
     * @param encoding
     * @throws IOException
     */
    public void writeStringToFile(File file, String data, Charset encoding) throws IOException {
        FileUtils.writeStringToFile(file, data, encoding);
    }

    /**
     * 根据对应编码把字符串写进对应的文件中
     * 
     * @param file
     * @param data
     * @param encoding
     * @throws IOException
     */
    public void writeStringToFile(File file, String data, String encoding) throws IOException {
        FileUtils.writeStringToFile(file, data, encoding);
    }

    /**
     * 
     * @param file
     * @param data
     * @param encoding
     * @param append
     * @throws IOException
     */
    public void writeStringToFile(File file, String data, Charset encoding, boolean append) throws IOException {
        FileUtils.writeStringToFile(file, data, encoding, append);
    }

    /**
     * 
     * @param file
     * @param data
     * @param encoding
     * @param append
     * @throws IOException
     */
    public void writeStringToFile(File file, String data, String encoding, boolean append) throws IOException {
        FileUtils.writeStringToFile(file, data, encoding, append);
    }

    /**
     * 根据虚拟机默认编码把字符串写进对应的文件中
     * 
     * @param file
     * @param data
     * @throws IOException
     */
    public void writeStringToFile(File file, String data) throws IOException {
        FileUtils.writeStringToFile(file, data);
    }

    /**
     * 
     * @param file
     * @param data
     * @param append
     * @throws IOException
     */
    public void writeStringToFile(File file, String data, boolean append) throws IOException {
        FileUtils.writeStringToFile(file, data, append);
    }

    /**
     * 根据虚拟机默认的编码把CharSequence写入到文件中
     * 
     * @param file
     * @param data
     * @throws IOException
     */
    public void write(File file, CharSequence data) throws IOException {
        FileUtils.write(file, data);
    }

    /**
     * 
     * @param file
     * @param data
     * @param append
     * @throws IOException
     */
    public void write(File file, CharSequence data, boolean append) throws IOException {
        FileUtils.write(file, data, append);
    }

    /**
     * 
     * @param file
     * @param data
     * @param encoding
     * @throws IOException
     */
    public void write(File file, CharSequence data, Charset encoding) throws IOException {
        FileUtils.write(file, data, encoding);
    }

    /**
     * 根据对应的编码把CharSequence写入到文件中
     * 
     * @param file
     * @param data
     * @param encoding
     * @throws IOException
     */
    public void write(File file, CharSequence data, String encoding) throws IOException {
        FileUtils.write(file, data, encoding);
    }

    /**
     * 
     * @param file
     * @param data
     * @param encoding
     * @param append
     * @throws IOException
     */
    public void write(File file, CharSequence data, Charset encoding, boolean append) throws IOException {
        FileUtils.write(file, data, encoding, append);
    }

    /**
     * 
     * @param file
     * @param data
     * @param encoding
     * @param append
     * @throws IOException
     */
    public void write(File file, CharSequence data, String encoding, boolean append) throws IOException {
        FileUtils.write(file, data, encoding, append);
    }

    /**
     * 把一个字节数组写入到指定的文件中
     * 
     * @param file
     * @param data
     * @throws IOException
     */
    public void writeByteArrayToFile(File file, byte[] data) throws IOException {
        FileUtils.writeByteArrayToFile(file, data);
    }

    /**
     * 
     * @param file
     * @param data
     * @param append
     * @throws IOException
     */
    public void writeByteArrayToFile(File file, byte[] data, boolean append) throws IOException {
        FileUtils.writeByteArrayToFile(file, data, append);
    }

    /**
     * 把集合中的内容根据对应编码逐项插入到文件中
     * 
     * @param file
     * @param encoding
     * @param lines
     * @throws IOException
     */
    public void writeLines(File file, String encoding, Collection<?> lines) throws IOException {
        FileUtils.writeLines(file, encoding, lines);
    }

    /**
     * 
     * @param file
     * @param encoding
     * @param lines
     * @param append
     * @throws IOException
     */
    public void writeLines(File file, String encoding, Collection<?> lines, boolean append) throws IOException {
        FileUtils.writeLines(file, encoding, lines, append);
    }

    /**
     * 把集合中的内容根据虚拟机默认编码逐项插入到文件中
     * 
     * @param file
     * @param lines
     * @throws IOException
     */
    public void writeLines(File file, Collection<?> lines) throws IOException {
        FileUtils.writeLines(file, lines);
    }

    /**
     * 
     * @param file
     * @param lines
     * @param append
     * @throws IOException
     */
    public void writeLines(File file, Collection<?> lines, boolean append) throws IOException {
        FileUtils.writeLines(file, lines, append);
    }

    /**
     * 把集合中的内容根据对应字符编码和行编码逐项插入到文件中
     * 
     * @param file
     * @param encoding
     * @param lines
     * @param lineEnding
     * @throws IOException
     */
    public void writeLines(File file, String encoding, Collection<?> lines, String lineEnding) throws IOException {
        FileUtils.writeLines(file, encoding, lines, lineEnding);
    }

    /**
     * 
     * @param file
     * @param encoding
     * @param lines
     * @param lineEnding
     * @param append
     * @throws IOException
     */
    public void writeLines(File file, String encoding, Collection<?> lines, String lineEnding, boolean append) throws IOException {
        FileUtils.writeLines(file, encoding, lines, lineEnding, append);
    }

    /**
     * 把集合中的内容根据对应行编码逐项插入到文件中
     * 
     * @param file
     * @param lines
     * @param lineEnding
     * @throws IOException
     */
    public void writeLines(File file, Collection<?> lines, String lineEnding) throws IOException {
        FileUtils.writeLines(file, lines, lineEnding);
    }

    /**
     * 
     * @param file
     * @param lines
     * @param lineEnding
     * @param append
     * @throws IOException
     */
    public void writeLines(File file, Collection<?> lines, String lineEnding, boolean append) throws IOException {
        FileUtils.writeLines(file, lines, lineEnding, append);
    }

    /**
     * 删除一个文件，如果是目录则递归删除
     * 
     * @param file
     * @throws IOException
     */
    public void forceDelete(File file) throws IOException {
        FileUtils.forceDelete(file);
    }

    /**
     * 当虚拟机退出关闭时删除文件
     * 
     * @param file
     * @throws IOException
     */
    public void forceDeleteOnExit(File file) throws IOException {
        FileUtils.forceDeleteOnExit(file);
    }

    /**
     * 创建一个目录除了不存在的父目录其他所必须的都可以创建
     * 
     * @param directory
     * @throws IOException
     */
    public void forceMkdir(File directory) throws IOException {
        FileUtils.forceMkdir(directory);
    }

    /**
     * 获取文件或者目录的大小
     * 
     * @param file
     * @return long
     */
    public long sizeOf(File file) {
        return FileUtils.sizeOf(file);
    }

    /**
     * 
     * @param file
     * @return BigInteger
     */
    public BigInteger sizeOfAsBigInteger(File file) {
        return FileUtils.sizeOfAsBigInteger(file);
    }

    /**
     * 获取目录的大小
     * 
     * @param directory
     * @return long
     */
    public long sizeOfDirectory(File directory) {
        return FileUtils.sizeOfDirectory(directory);
    }

    /**
     * 
     * @param directory
     * @return BigInteger
     */
    public BigInteger sizeOfDirectoryAsBigInteger(File directory) {
        return FileUtils.sizeOfDirectoryAsBigInteger(directory);
    }

    /**
     * 测试指定文件的最后修改日期是否比reference的文件新
     * 
     * @param file
     * @param reference
     * @return boolean
     */
    public boolean isFileNewer(File file, File reference) {
        return FileUtils.isFileNewer(file, reference);
    }

    /**
     * 检测指定文件的最后修改时间是否在指定日期之前
     * 
     * @param file
     * @param date
     * @return boolean
     */
    public boolean isFileNewer(File file, Date date) {
        return FileUtils.isFileNewer(file, date);
    }

    /**
     * 检测指定文件的最后修改时间（毫秒）是否在指定日期之前
     * 
     * @param file
     * @param timeMillis
     * @return boolean
     */
    public boolean isFileNewer(File file, long timeMillis) {
        return FileUtils.isFileNewer(file, timeMillis);
    }

    /**
     * 检测指定文件的最后修改日期是否比reference文件的晚
     * 
     * @param file
     * @param reference
     * @return boolean
     */
    public boolean isFileOlder(File file, File reference) {
        return FileUtils.isFileOlder(file, reference);
    }

    /**
     * 检测指定文件的最后修改时间是否在指定日期之后
     * 
     * @param file
     * @param date
     * @return boolean
     */
    public boolean isFileOlder(File file, Date date) {
        return FileUtils.isFileOlder(file, date);
    }

    /**
     * 检测指定文件的最后修改时间（毫秒）是否在指定日期之后
     * 
     * @param file
     * @param timeMillis
     * @return boolean
     */
    public boolean isFileOlder(File file, long timeMillis) {
        return FileUtils.isFileOlder(file, timeMillis);
    }

    /**
     * 计算使用CRC32校验程序文件的校验和
     * 
     * @param file
     * @return long
     * @throws IOException
     */
    public long checksumCRC32(File file) throws IOException {
        return FileUtils.checksumCRC32(file);
    }

    /**
     * 计算一个文件使用指定的校验对象的校验
     * 
     * @param file
     * @param checksum
     * @return Checksum
     * @throws IOException
     */
    public Checksum checksum(File file, Checksum checksum) throws IOException {
        return FileUtils.checksum(file, checksum);
    }

    /**
     * 移动目录到新的目录并且删除老的目录
     * 
     * @param srcDir
     * @param destDir
     * @throws IOException
     */
    public void moveDirectory(File srcDir, File destDir) throws IOException {
        FileUtils.moveDirectory(srcDir, destDir);
    }

    /**
     * 把一个目录移动到另一个目录中去
     * 
     * @param src
     * @param destDir
     * @param createDestDir
     * @throws IOException
     */
    public void moveDirectoryToDirectory(File src, File destDir, boolean createDestDir) throws IOException {
        FileUtils.moveDirectoryToDirectory(src, destDir, createDestDir);
    }

    /**
     * 复制文件到对应的文件中去
     * 
     * @param srcFile
     * @param destFile
     * @throws IOException
     */
    public void moveFile(File srcFile, File destFile) throws IOException {
        FileUtils.moveFile(srcFile, destFile);
    }

    /**
     * 复制文件到对应的文件中去，可设置当目标文件不存在时是否创建新的文件
     * 
     * @param srcFile
     * @param destDir
     * @param createDestDir
     * @throws IOException
     */
    public void moveFileToDirectory(File srcFile, File destDir, boolean createDestDir) throws IOException {
        FileUtils.moveFileToDirectory(srcFile, destDir, createDestDir);
    }

    /**
     * 移动文件或者目录到新的路径下，并且设置在目标路径不存在的情况下是否创建
     * 
     * @param src
     * @param destDir
     * @param createDestDir
     * @throws IOException
     */
    public void moveToDirectory(File src, File destDir, boolean createDestDir) throws IOException {
        FileUtils.moveToDirectory(src, destDir, createDestDir);
    }

    /**
     * 确定指定的文件是否是一个符号链接，而不是实际的文件
     * 
     * @param file
     * @return boolean
     * @throws IOException
     */
    public boolean isSymlink(File file) throws IOException {
        return FileUtils.isSymlink(file);
    }

}
