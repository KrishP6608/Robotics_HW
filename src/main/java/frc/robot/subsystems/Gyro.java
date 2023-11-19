
package frc.robot;

import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.commands.raiseElevator;
import frc.robot.subsystems.Elevator;
import com.ctre.phoenix.sensors.WPI_PigeonIMU;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;


public class Gyro extends Subsystem {

  public TalonSRX motor = new TalonSRX(7);
  public WPI_PigeonIMU gyro = new WPI_PigeonIMU(motor);
  private Elevator elevator = new Elevator();
  int targetAngle;
  boolean raised;
  int angle;

  public checkAngle(){
    while (!raised){
        angle = gyro.getAngle();
        if (angle == targetAngle){
            raiseElevator();
        }
    }
  }


}
