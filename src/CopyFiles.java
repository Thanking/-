import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;

public class CopyFiles {

	public static void main(String[] args) {
		//源文件
		File src = new File("D:\\2345好压");
		
		//目标文件
		File targetFile = new File("C:\\Users\\扶藜\\Desktop\\COPY");
		
		//调用方法进行复制
		copyFile(src,targetFile);

	}
	
	//copy文件夹及文件
	@SuppressWarnings("resource")
	public static void copyFile(File src ,File target) {
		//判断
		if(src.isDirectory()) {//复制文件夹
			//如果不是文件夹
			if(!target.isDirectory()) {
				//创建一个
				target.mkdir();
			}
			
			//获取当前文件夹下的所有文件名
			String[] fileNames = src.list();
			//循环
			for(String name:fileNames) {
				System.out.println("name: " + name);
				File f1 = new File(src,name);
				//复制的文件夹生成
				File f2 = new File(target,name);
				
				//递归调用copyFile
				copyFile(f1, f2);
			}
			
		}else {//复制文件
			
			 try(
				InputStream is = new FileInputStream(src);
				OutputStream os = new FileOutputStream(target);	
				){
				//定义ien
				int len;
				//缓冲
				byte[] b = new byte[1024*8];
				//循环
				while((len = is.read(b)) > 0 ) {
					//写出去
					os.write(b, 0, len);
				}
				
				System.out.println("我已复制完了");
				
			} catch (IOException e) {
				e.printStackTrace();
			}
			 
			
			/**
			 try {
				FileOutputStream os = new FileOutputStream(target);
				//文件工具类 Paths.get(文件路径)
				Files.copy(Paths.get(src.toString()), os);
			}catch(IOException e) {
				e.printStackTrace();
			}
			 */
			
		}
		
	}

}
