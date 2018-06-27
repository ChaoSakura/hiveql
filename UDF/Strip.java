package thisisnobody.udf;

import org.apache.commons.lang3.StringUtils;
import org.apache.hadoop.hive.ql.exec.UDF;
import org.apache.hadoop.io.Text;

public class Strip extends UDF {

	private Text result = new Text();

	//ȥ���հ��ַ�
	public Text evaluate(Text str) {
		if (str == null) {
			return null;
		}
		result.set(StringUtils.strip(str.toString()));
		return result;

	}
	
	//�ַ�����ͷ��β������stripChars�е��ַ�
	// ('banana', 'ab') => nan
	// ('ababababa', 'ab') => null
	public Text evaluate(Text str, String stripChars) {
		if (str == null) {
			return null;
		}

		result.set(StringUtils.strip(str.toString(), stripChars));
		return result;

	}
}
