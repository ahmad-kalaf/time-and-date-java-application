import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

@SuppressWarnings("serial")
public class TimeGUI extends JFrame {
	
	private SimpleDateFormat _timeFormat, _dayFormat, _dateFormat;
	private JLabel _timeLabel, _dayLabel, _dateLabel;
	
	TimeGUI() {
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setSize(350,200);
		this.setTitle("TIME");
		this.setLayout(new GridLayout(0,1));
		
		_timeFormat = new SimpleDateFormat("kk:mm:ss");
		_dayFormat = new SimpleDateFormat("EEEE");
		_dateFormat = new SimpleDateFormat("dd.MM.yyyy");
		
		_timeLabel = new JLabel();
		_timeLabel.setFont(new Font("Lucida Handwriting", Font.PLAIN, 50));
		_timeLabel.setOpaque(true);
		_timeLabel.setBackground(Color.black);
		_timeLabel.setForeground(new Color(0xd7de10));
		_timeLabel.setHorizontalAlignment(SwingConstants.CENTER);
		
		_dayLabel = new JLabel();
		_dayLabel.setFont(new Font("Inc Free", Font.PLAIN, 30));
		_dayLabel.setHorizontalAlignment(SwingConstants.CENTER);
		
		_dateLabel = new JLabel();
		_dateLabel.setFont(new Font("Inc Free", Font.PLAIN, 30));
		_dateLabel.setHorizontalAlignment(SwingConstants.CENTER);
		
		this.add(_timeLabel);
		this.add(_dayLabel);
		this.add(_dateLabel);
		this.setVisible(true);
		reload();
		
	}
	private void reload() {
		while(true) {
			String _time = _timeFormat.format(Calendar.getInstance().getTime());
			_timeLabel.setText(_time);
			
			String _day = _dayFormat.format(Calendar.getInstance().getTime());
			_dayLabel.setText(_day);
			
			String _date = _dateFormat.format(Calendar.getInstance().getTime());
			_dateLabel.setText(_date);
			
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
