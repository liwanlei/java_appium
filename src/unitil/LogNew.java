/**
 * 
 */
package unitil;

import org.apache.log4j.*;
import org.testng.Reporter;

/**
 * @author lileilei
 *
 */
public class LogNew {
	private Logger logger;
	public LogNew(Class<?> clazz){
		logger = Logger.getLogger(clazz);
		}
	public LogNew(String s){
		logger = Logger.getLogger(s);
		}
	public LogNew(){
		logger = Logger.getLogger("");
		}
	public void info(Object message){
		logger.info(message);
		this.testngLogOutput(message);
		}
		public void error(Object message){
		logger.error(message);
		this.testngLogOutput(message);
		}
		public void warn(Object message){
		logger.warn(message);
		this.testngLogOutput(message);
		}
		public void debug(Object message){
			logger.debug(message);
			this.testngLogOutput(message);
			}
			private void testngLogOutput(Object message){
			Reporter.log(message.toString());
			}
}
