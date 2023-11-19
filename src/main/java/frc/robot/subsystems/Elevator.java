
package frc.robot;


import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import edu.wpi.first.wpilibj.command.Subsystem;



public class Elevator extends Subsystem {
  
  private CANSparkMax motor1 = new CANSparkMax(4, MotorType.kBrushless);
  private CANSparkMax motor2 = new CANSparkMax(5, MotorType.kBrushless);
  

}
