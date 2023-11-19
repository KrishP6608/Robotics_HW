
package frc.robot;


import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.command.Subsystem;
import com.revrobotics.CANSparkMax;
import com.ctre.phenix.sensors.WPI_PigeonIMU;


public class ArcadeDrive extends Subsystem {
  
  private CANSparkMax leftMotor1 = new CANSparkMax(0);
  private CANSparkMax leftMotor2 = new CANSparkMax(1);
  private CANSparkMax rightMotor1 = new CANSparkMax(3);
  private CANSparkMax rightMotor2 = new CANSparkMax(4);
  
  leftMotors = new SpeedControllerGroup(leftMotor1, leftMotor2);
  rightMotors = new SpeedControllerGroup(rightMotor1, rightMotor2);
  
  rightMotors.setInverted(true);

  public DifferentialDrive differentialDrive = new DifferentialDrive(leftMotors, rightMotors);

  public WPI_PigeonIMU gyro = new WPI_PigeonIMU(0);

  public void move(doubel moveSpeed, double turnSpeed){
    left = moveSpeed + turnSpeed;
    right = moveSpeed - turnSpeed;
    differentialDrive.arcadeDrive(left, right);
  }

  public getAngle(){
    return gyro.getAngle();
  }


}
