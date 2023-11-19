
package frc.robot;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.Joystick;
import frc.robot.commands.move_turn;
import frc.robot.subsystems.ArcadeDrive;
import frc.robot.RobotContainer;


public class Robot extends TimedRobot {
  public static ArcadeDrive arcadeDrive = new ArcadeDrive();

  Command autonomousCommand;

  @Override
  public void robotInit() {

  }
  
  @Override
  public void robotPeriodic() {
  }

  @Override
  public void disabledInit() {
  }

  @Override
  public void disabledPeriodic() {
    Scheduler.getInstance().run();
  }
 
  @Override
  public void autonomousInit() {
    autonomousCommand = RobotContainer.getAutonomousCommand();

    if (autonomousCommand != null) {
      autonomousCommand.start();
    }
  }

  @Override
  public void autonomousPeriodic() {
    Scheduler.getInstance().run();
  }

  @Override
  public void teleopInit() {
    
    if (autonomousCommand != null) {
      autonomousCommand.cancel();
    }
  }

  @Override
  public void teleopPeriodic() {
    Scheduler.getInstance().run();
  }

  @Override
  public void testPeriodic() {
  }
}
