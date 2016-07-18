package GUI;
import java.awt.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.tree.*;
import Standalone.*;

public class Panel_DropSpotTree extends JPanel implements TreeSelectionListener {

	private static final long		serialVersionUID		= 1L;

	GUI_Controller					Class_Controller;

	private JPanel					TotalPanel;
	JScrollPane						TreeScrollPane;

	JTree							DropSpotTree;
	DefaultMutableTreeNode			TopNode;

	int								Kategori_DropSpotType_Nr;
	DefaultMutableTreeNode[]		Kategori_DropSpotType	= new DefaultMutableTreeNode[900];
	int								Kategori_Continent_Nr;
	DefaultMutableTreeNode[]		Kategori_Continent		= new DefaultMutableTreeNode[900];
	int								Kategori_Zone_Nr;
	DefaultMutableTreeNode[]		Kategori_Zone			= new DefaultMutableTreeNode[900];
	int								Kategori_Level_Nr;
	DefaultMutableTreeNode[]		Kategori_Level			= new DefaultMutableTreeNode[900];
	int								Kategori_Difficulty_Nr;
	DefaultMutableTreeNode[]		Kategori_Difficulty		= new DefaultMutableTreeNode[900];
	int								Kategori_Instance_Nr;
	DefaultMutableTreeNode[]		Kategori_Instance			= new DefaultMutableTreeNode[9000];
	private int						DropSpot_Nr;
	DefaultMutableTreeNode[]		DropSpotNode			= new DefaultMutableTreeNode[9000];

	public DropSpotInNode					SelectedNodeClass;
	private DefaultMutableTreeNode	SelectedNodeObject;
	private String					SelectedNodeType;
	public String							Selected_DropSpotType;
	public String							Selected_Continent;
	public String							Selected_Zone;
	public int								Selected_Level;
	public String							Selected_Difficulty;
	public String							Selected_Instance;

	boolean							Ready					= false;

	public Panel_DropSpotTree ( GUI_Controller Class_Controller ) {

		super ( new GridLayout ( 1, 0 ) );
		this.Class_Controller = Class_Controller;

		for ( int A = 0 ; A < this.Kategori_DropSpotType.length ; A++ ) {
			this.Kategori_DropSpotType[A] = new DefaultMutableTreeNode ( );
		}
		for ( int A = 0 ; A < this.Kategori_Continent.length ; A++ ) {
			this.Kategori_Continent[A] = new DefaultMutableTreeNode ( );
		}
		for ( int A = 0 ; A < this.Kategori_Zone.length ; A++ ) {
			this.Kategori_Zone[A] = new DefaultMutableTreeNode ( );
		}
		for ( int A = 0 ; A < this.Kategori_Level.length ; A++ ) {
			this.Kategori_Level[A] = new DefaultMutableTreeNode ( );
		}
		for ( int A = 0 ; A < this.Kategori_Difficulty.length ; A++ ) {
			this.Kategori_Difficulty[A] = new DefaultMutableTreeNode ( );
		}
		for ( int A = 0 ; A < this.Kategori_Instance.length ; A++ ) {
			this.Kategori_Instance[A] = new DefaultMutableTreeNode ( );
		}
		for ( int A = 0 ; A < this.DropSpotNode.length ; A++ ) {
			this.DropSpotNode[A] = new DefaultMutableTreeNode ( );
		}
		
		Startup();
	}

	public void Startup ( ) {

		this.TopNode = new DefaultMutableTreeNode ( "Drop spots" );
		CreateTree ( );

		this.TotalPanel = new JPanel ( );

		this.DropSpotTree = new JTree ( this.TopNode );
		this.DropSpotTree.getSelectionModel ( ).setSelectionMode ( TreeSelectionModel.SINGLE_TREE_SELECTION );
		this.DropSpotTree.addTreeSelectionListener ( this );

		this.TreeScrollPane = new JScrollPane ( this.DropSpotTree );

		Dimension minimumSize = new Dimension ( 50, 50 );
		this.TreeScrollPane.setMinimumSize ( minimumSize );
		this.TotalPanel.setMinimumSize ( minimumSize );
		//this.TreeScrollPane.setPreferredSize ( new Dimension ( 250, 200 ) );
		//this.TotalPanel.setPreferredSize ( new Dimension ( 250, 200 ) );
		this.TreeScrollPane.setPreferredSize ( new Dimension ( 250, 500 ) );
		this.TotalPanel.setPreferredSize ( new Dimension ( 250, 500 ) );

		this.TotalPanel.add ( this.TreeScrollPane );
		add ( this.TotalPanel );
		this.Ready = true;
	}

	public void valueChanged ( TreeSelectionEvent e ) {
		this.SelectedNodeObject = ( DefaultMutableTreeNode ) this.DropSpotTree.getLastSelectedPathComponent ( );
		this.SelectedNodeType = null;
		this.SelectedNodeClass = null;
		if ( this.SelectedNodeObject != null ){
			//System.out.println ( "Node: " + SelectedNodeObject+" Leaf="+SelectedNodeObject.isLeaf ( ));
			Object nodeInfo = this.SelectedNodeObject.getUserObject ( );
			//System.out.println ( nodeInfo);
			if ( this.SelectedNodeObject.isLeaf ( ) ) {
				this.SelectedNodeType = "Name";
				this.SelectedNodeClass = ( DropSpotInNode ) nodeInfo;
				//ShowDropSpotInfo ( this.SelectedNodeClass.Name );
				this.Selected_DropSpotType = this.SelectedNodeClass.NodeContent.Get_DropSpotType ( );
				this.Selected_Continent = this.SelectedNodeClass.NodeContent.Get_Continent ( );
				this.Selected_Zone = this.SelectedNodeClass.NodeContent.Get_Zone ( );
				this.Selected_Level = this.SelectedNodeClass.NodeContent.Get_levelReq ( );
				this.Selected_Difficulty = this.SelectedNodeClass.NodeContent.Get_Difficulty ( );
				this.Selected_Instance = this.SelectedNodeClass.NodeContent.Get_Instance ( );
			} else {
				this.SelectedNodeType = null;
				this.Selected_DropSpotType = null;
				this.Selected_Continent = null;
				this.Selected_Zone = null;
				this.Selected_Level = 0;
				this.Selected_Difficulty = null;
				this.Selected_Instance = null;

				for ( int A = 0 ; A < this.Kategori_DropSpotType.length ; A++ ) {
					if ( this.Kategori_DropSpotType[A].toString ( ) != null ) {
						if ( this.Kategori_DropSpotType[A].equals ( this.SelectedNodeObject ) ) {
							this.SelectedNodeType = "DropSpotType";
							this.Selected_DropSpotType = this.Kategori_DropSpotType[A].toString ( );
							this.Selected_Continent = null;
							this.Selected_Zone = null;
							this.Selected_Level = 0;
							this.Selected_Difficulty = null;
							this.Selected_Instance = null;
						} else {
							if ( this.Kategori_DropSpotType[A].isNodeDescendant ( this.SelectedNodeObject ) ) {
								this.Selected_DropSpotType = this.Kategori_DropSpotType[A].toString ( );
							}
						}
					}
				}
				for ( int A = 0 ; A < this.Kategori_Continent.length ; A++ ) {
					if ( this.Kategori_Continent[A].toString ( ) == null ) {
					} else {
						if ( this.Kategori_Continent[A].toString ( ).equals ( this.SelectedNodeObject.toString ( ) ) ) {
							this.SelectedNodeType = "Continent";
							this.Selected_Continent = this.Kategori_Continent[A].toString ( );
							this.Selected_Zone = null;
							this.Selected_Level = 0;
							this.Selected_Difficulty = null;
						} else {
							if ( this.Kategori_Continent[A].isNodeDescendant ( this.SelectedNodeObject ) ) {
								this.Selected_Continent = this.Kategori_Continent[A].toString ( );
							}
						}
					}
				}
				for ( int A = 0 ; A < this.Kategori_Zone.length ; A++ ) {
					if ( this.Kategori_Zone[A].toString ( ) == null ) {
					} else {
						if ( this.Kategori_Zone[A].toString ( ).equals ( this.SelectedNodeObject.toString ( ) ) ) {
							if ( this.SelectedNodeObject.getParent ( ).getParent ( ).equals ( this.TopNode ) ) { //sjekker om det er et kontinent og ikke en sone.
								if ( this.SelectedNodeObject.getParent ( ).toString ( ).equals ( "PVP" ) ) {
									this.SelectedNodeType = "Zone";
									this.Selected_Zone = this.Kategori_Zone[A].toString ( );
									this.Selected_Level = 0;
									this.Selected_Difficulty = null;
								}
							} else {
								if ( this.Kategori_Zone[A].isNodeDescendant ( this.SelectedNodeObject ) ) {
									this.Selected_Zone = this.Kategori_Zone[A].toString ( );
								}
							}
						}
					}
				}
				for ( int A = 0 ; A < this.Kategori_Level.length ; A++ ) {
					if ( this.Kategori_Level[A].toString ( ) != null ) {
						if ( this.Kategori_Level[A].toString ( ).equals ( this.SelectedNodeObject.toString ( ) ) ) {
							this.SelectedNodeType = "Level";
							this.Selected_Level = Integer.parseInt ( this.Kategori_Level[A].toString ( ) );
							this.Selected_Difficulty = null;
						} else {
							if ( this.Kategori_Level[A].isNodeDescendant ( this.SelectedNodeObject ) ) {
								this.Selected_Level = Integer.parseInt ( this.Kategori_Level[A].toString ( ) );
							}
						}
					}
				}
				for ( int A = 0 ; A < this.Kategori_Difficulty.length ; A++ ) {
					if ( this.Kategori_Difficulty[A].toString ( ) == null ) {
					} else {
						if ( this.Kategori_Difficulty[A].toString ( ).equals ( this.SelectedNodeObject.toString ( ) ) ) {
							this.SelectedNodeType = "Difficulty";
							this.Selected_Difficulty = this.Kategori_Difficulty[A].toString ( );
						} else {
							if ( this.Kategori_Difficulty[A].isNodeDescendant ( this.SelectedNodeObject ) ) {
								this.Selected_Difficulty = this.Kategori_Difficulty[A].toString ( );
							}
						}
					}
				}
				for ( int A = 0 ; A < this.Kategori_Instance.length ; A++ ) {
					if ( this.Kategori_Instance[A].toString ( ) == null ) {
					} else {
						if ( this.Kategori_Instance[A].toString ( ).equals ( this.SelectedNodeObject.toString ( ) ) ) {
							this.SelectedNodeType = "Instance";
							this.Selected_Instance = this.Kategori_Instance[A].toString ( );
						} else {
							if ( this.Kategori_Instance[A].isNodeDescendant ( this.SelectedNodeObject ) ) {
								this.Selected_Instance = this.Kategori_Instance[A].toString ( );
							}
						}
					}
				}
			}
			this.Class_Controller.UserCommand_DropSpotTreeSelection ( this );
		}
	}

	public class DropSpotInNode {

		public Interface_Dropspot	NodeContent;
		public String				Name;

		public DropSpotInNode ( Interface_Dropspot interface_Dropspot ) {
			this.NodeContent = interface_Dropspot;
			this.Name = interface_Dropspot.Get_Name ( );
		}

		@Override
		public String toString ( ) {
			return this.Name;
		}
		
	}

	private void CreateTree ( ) {
		//System.out.println ( "--- panel drop spot setting up tree" );
		AddCategory_DropSpotType ( this.TopNode );
		
		for ( int A = 1 ; A < this.Kategori_Difficulty.length ; A++ ) {
			if ( this.Kategori_Difficulty[A].toString ( ) != null ) {
				if ( this.Kategori_Difficulty[A].getChildCount ( ) == 0 ) {
					//System.out.println ( "Skal fjerne Kategori_DropSpotType "+Kategori_DropSpotType[A]);
					this.Kategori_Difficulty[A].removeFromParent ( );
				}
			}
		}
		
		for ( int A = 1 ; A < this.Kategori_Instance.length ; A++ ) {
			if ( this.Kategori_Instance[A].toString ( ) != null ) {
				if ( this.Kategori_Instance[A].getChildCount ( ) == 0 ) {
					//System.out.println ( "Skal fjerne Kategori_Instance "+Kategori_Instance[A]);
					this.Kategori_Instance[A].removeFromParent ( );
				}
			}
		}
		for ( int A = 1 ; A < this.Kategori_Level.length ; A++ ) {
			if ( this.Kategori_Level[A].toString ( ) != null ) {
				if ( this.Kategori_Level[A].getChildCount ( ) == 0 ) {
					//System.out.println ( "Skal fjerne level "+Kategori_Level[A]);
					this.Kategori_Level[A].removeFromParent ( );
				}
			}
		}
		for ( int A = 1 ; A < this.Kategori_Zone.length ; A++ ) {
			if ( this.Kategori_Zone[A].toString ( ) != null ) {
				if ( this.Kategori_Zone[A].getChildCount ( ) == 0 ) {
					//System.out.println ( "Skal fjerne Kategori_Zone "+Kategori_Zone[A]);
					this.Kategori_Zone[A].removeFromParent ( );
				}
			}
		}
		for ( int A = 1 ; A < this.Kategori_Continent.length ; A++ ) {
			if ( this.Kategori_Continent[A].toString ( ) != null ) {
				if ( this.Kategori_Continent[A].getChildCount ( ) == 0 ) {
					//System.out.println ( "Skal fjerne Kategori_Continent "+Kategori_Continent[A]);
					this.Kategori_Continent[A].removeFromParent ( );
				}
			}
		}
		for ( int A = 1 ; A < this.Kategori_DropSpotType.length ; A++ ) {
			if ( this.Kategori_DropSpotType[A].toString ( ) != null ) {
				if ( this.Kategori_DropSpotType[A].getChildCount ( ) == 0 ) {
					//System.out.println ( "Skal fjerne Kategori_DropSpotType "+Kategori_DropSpotType[A]);
					this.Kategori_DropSpotType[A].removeFromParent ( );
				}
			}
		}
	}

	public void AddCategory_DropSpotType ( DefaultMutableTreeNode ParentCategory ) {
		
		String[] DropSpotType = Class_Controller.Get_DropSpotTypes();

		if ( DropSpotType != null ){
			for ( int A = 0 ; A < DropSpotType.length ; A++ ) {
				if ( DropSpotType[A] != null ) {
					this.Kategori_DropSpotType_Nr++;
					this.Kategori_DropSpotType[this.Kategori_DropSpotType_Nr] = new DefaultMutableTreeNode ( DropSpotType[A] );
					ParentCategory.add ( this.Kategori_DropSpotType[this.Kategori_DropSpotType_Nr] );
					
					if ( DropSpotType[A].equals ( "Quest" ) ) {
						AddCategory_Continent ( this.Kategori_DropSpotType[this.Kategori_DropSpotType_Nr], DropSpotType[A], null, 0, null, null, null );
					} else 
						if ( DropSpotType[A].equals ( "Raid" ) ) {
						AddCategory_LevelReq ( this.Kategori_DropSpotType[this.Kategori_DropSpotType_Nr], DropSpotType[A], null, 0, null, null, null );
					} else 
						if ( DropSpotType[A].equals ( "Faction" ) ) {
						AddCategory_Continent ( this.Kategori_DropSpotType[this.Kategori_DropSpotType_Nr], DropSpotType[A], null, 0, null, null, null );
					} else 
						if ( DropSpotType[A].equals ( "Various" ) ) {
						AddCategory_Continent ( this.Kategori_DropSpotType[this.Kategori_DropSpotType_Nr], DropSpotType[A], null, 0, null, null, null );
					} else 
						if ( DropSpotType[A].equals ( "Tokens" ) ) {
						Add_DropSpot ( this.Kategori_DropSpotType[this.Kategori_DropSpotType_Nr], DropSpotType[A], null, 0, null, null, null );
					} else 
						if ( DropSpotType[A].equals ( "Instance" ) ) {
						AddCategory_Continent ( this.Kategori_DropSpotType[this.Kategori_DropSpotType_Nr], DropSpotType[A], null, 0, null, null, null );
					} else 
						if ( DropSpotType[A].equals ( "PVP" ) ) {
						AddCategory_Zone ( this.Kategori_DropSpotType[this.Kategori_DropSpotType_Nr], DropSpotType[A], null, 0, null, null, null );
					} else 
						if ( DropSpotType[A].equals ( "Profession" ) ) {
						Add_DropSpot ( this.Kategori_DropSpotType[this.Kategori_DropSpotType_Nr], DropSpotType[A], null, 0, null, null, null );
					}
				}
			}
		}
	}

	public void AddCategory_Continent ( DefaultMutableTreeNode ParentCategory, String DropSpotType, String Continent, int LevelReq, String Difficulty, String Instance, String Zone ) {
		
		String[] ContinentLocation = Class_Controller.Get_ContinentLocations();
		
		for ( int B = 0 ; B < ContinentLocation.length ; B++ ) {
			if ( ContinentLocation[B] != null ) {
				this.Kategori_Continent_Nr++;
				this.Kategori_Continent[this.Kategori_Continent_Nr] = new DefaultMutableTreeNode ( ContinentLocation[B] );
				ParentCategory.add ( this.Kategori_Continent[this.Kategori_Continent_Nr] );
				if ( DropSpotType.equals ( "Instance" ) ) {
					AddCategory_Instance ( this.Kategori_Continent[this.Kategori_Continent_Nr], DropSpotType, ContinentLocation[B], LevelReq, Difficulty, Instance, Zone );
				} else {
					Add_DropSpot ( this.Kategori_Continent[this.Kategori_Continent_Nr], DropSpotType, ContinentLocation[B], LevelReq, Difficulty, Instance, Zone );
				}
			}
		}
		
	}

	public void AddCategory_LevelReq ( DefaultMutableTreeNode ParentCategory, String DropSpotType, String Continent, int LevelReq, String Difficulty, String Instance, String Zone ) {
		
		int[] LevelReqs = Class_Controller.Get_LevelReqs();
		
		for ( int B = 0 ; B < LevelReqs.length ; B++ ) {
			if ( LevelReqs[B] != 0 ) {
				this.Kategori_Level_Nr++;
				this.Kategori_Level[this.Kategori_Level_Nr] = new DefaultMutableTreeNode ( LevelReqs[B] );
				ParentCategory.add ( this.Kategori_Level[this.Kategori_Level_Nr] );
				AddCategory_Instance ( Kategori_Level[this.Kategori_Level_Nr], DropSpotType, Continent, LevelReq, Difficulty, Instance, Zone );
			}
		}
		
	}

	public void AddCategory_Zone ( DefaultMutableTreeNode ParentCategory, String DropSpotType, String Continent, int LevelReq, String Difficulty, String Instance, String Zone ) {
		
		String[] ZoneLocation = Class_Controller.Get_ZoneLocations();
		
		for ( int B = 0 ; B < ZoneLocation.length ; B++ ) {
			if ( ZoneLocation[B] != null ) {
				this.Kategori_Zone_Nr++;
				this.Kategori_Zone[this.Kategori_Zone_Nr] = new DefaultMutableTreeNode ( ZoneLocation[B] );
				ParentCategory.add ( this.Kategori_Zone[this.Kategori_Zone_Nr] );
				if ( DropSpotType.equals ( "PVP" ) ) {
					AddCategory_Instance ( this.Kategori_Zone[this.Kategori_Zone_Nr], DropSpotType, Continent, LevelReq, Difficulty, Instance, ZoneLocation[B] );
				} else {
					Add_DropSpot ( this.Kategori_Zone[this.Kategori_Zone_Nr], DropSpotType, Continent, LevelReq, Difficulty, Instance, ZoneLocation[B] );
				}
			}
		}
		
	}

	public void AddCategory_Difficulty ( DefaultMutableTreeNode ParentCategory, String DropSpotType, String Continent, int LevelReq, String Difficulty, String Instance, String Zone ) {
		
		String[] Difficultys = Class_Controller.Get_Difficultys();
		
		for ( int B = 0 ; B < Difficultys.length ; B++ ) {
			if ( Difficultys[B] != null ) {
				this.Kategori_Difficulty_Nr++;
				this.Kategori_Difficulty[this.Kategori_Difficulty_Nr] = new DefaultMutableTreeNode ( Difficultys[B] );
				ParentCategory.add ( this.Kategori_Difficulty[this.Kategori_Difficulty_Nr] );
				Add_DropSpot ( this.Kategori_Difficulty[this.Kategori_Difficulty_Nr], DropSpotType, Continent, LevelReq, Difficulty, Instance, Zone );
			}
		}
		
	}
	
	public void AddCategory_Instance ( DefaultMutableTreeNode ParentCategory, String DropSpotType, String Continent, int LevelReq, String Difficulty, String Instance, String Zone ) {
		
		String[] Instances = Class_Controller.Get_Instances();
		
		for ( int B = 0 ; B < Instances.length ; B++ ) {
			if ( Instances[B] != null ) {
				if ( Instances[B].equals ( "" ) == false ) {
					this.Kategori_Instance_Nr++;
					this.Kategori_Instance[this.Kategori_Instance_Nr] = new DefaultMutableTreeNode ( Instances[B] );
					ParentCategory.add ( this.Kategori_Instance[this.Kategori_Instance_Nr] );
					if ( DropSpotType.equals ( "Instance" ) ) {
						AddCategory_Difficulty ( this.Kategori_Instance[this.Kategori_Instance_Nr], DropSpotType, Continent, LevelReq, Difficulty, Instances[B], Zone );
					} else {
						Add_DropSpot ( this.Kategori_Instance[this.Kategori_Instance_Nr], DropSpotType, Continent, LevelReq, Difficulty, Instances[B], Zone );
					}
				}
			}
		}
		
	}

	public void Add_DropSpot ( DefaultMutableTreeNode ParentCategory, String DropSpotType, String Continent, int LevelReq, String Difficulty, String Instance, String Zone ) {

		//String[] DropSpotList_Name = Class_Controller.Get_DropSpotList_Name();
		Interface_Dropspot[] DropSpotList = Class_Controller.Get_DropSpotList();
		
		boolean Addable;
		for ( int F = 0 ; F < DropSpotList.length ; F++ ) {
			Addable = true;
			if ( DropSpotList[F] != null ) {
				//System.out.println ( "dropspottree sjekker drop spot #"+F);
				
				if ( DropSpotType == null ) {
				} else if ( DropSpotList[F].Get_DropSpotType().equals ( DropSpotType ) ) {
				} else {
					Addable = false;
				}
				
				if ( Addable == true ){
					if ( Instance == null ) {
					} else if ( DropSpotList[F].Get_Instance ( ).equals ( Instance ) ) {
					} else {
						Addable = false;
					}
				}
				
				if ( Addable == true ){
					if ( Zone == null ) {
					} else if ( DropSpotList[F].Get_Zone().equals ( Zone ) ) {
					} else {
						Addable = false;
					}
				}
				if ( Addable == true ){
					if ( Continent == null ) {
					} else if ( DropSpotList[F].Get_Continent().equals ( Continent ) ) {
						if ( Instance != null ) {
							//System.out.println("Add_DropSpot sier at " + Instance + " er i " + Continent);
						}
					} else {
						Addable = false;
					}
				}

				if ( Addable == true ){
					if ( LevelReq == 0 ) {
					} else if ( DropSpotList[F].Get_levelReq() == LevelReq ) {
					} else {
						Addable = false;
					}
				}

				if ( Addable == true ){
					if ( Difficulty == null ) {
					} else if ( DropSpotList[F].Get_Difficulty ( ).equals ( Difficulty ) ) {
					} else {
						Addable = false;
					}
				}

				if ( Addable == true ) {
					this.DropSpot_Nr++;
					this.DropSpotNode[this.DropSpot_Nr] = new DefaultMutableTreeNode ( new DropSpotInNode ( DropSpotList[F] ) );
					ParentCategory.add ( this.DropSpotNode[this.DropSpot_Nr] );
					//System.out.println ( "Addet " + Class_Controller.Class_Model_DropSpots.DropSpotList_Name[F].Name+", instance="+Instance+" zone="+DropSpotList_Name[F].ZoneLocation);
				}
			}
		}
	}

	public void SelectDropSpot ( int DropSpotID ) { //selecte en node utifra drop spot ID lagret i item som vises.
		
		if ( this.Ready == true ) {
			if ( DropSpotID == 0 ) {
				this.DropSpotTree.setSelectionRow ( 0 );
			} else {
				for ( int F = 1 ; F <= this.DropSpot_Nr ; F++ ) { //finn noden som representerer drop spot med ønsket ID
					if ( this.DropSpotNode[F] != null ) {
						DefaultMutableTreeNode ProcessedNode = this.DropSpotNode[F];
						Object nodeInfo = ProcessedNode.getUserObject ( );
						DropSpotInNode NodeClassObject = ( DropSpotInNode ) nodeInfo;
						if ( NodeClassObject.NodeContent.Get_ID() == DropSpotID ) { //fant drop spot lagret på item
							TreeNode[] NodePath1 = ProcessedNode.getPath ( );
							TreePath NodePath2 = new TreePath ( NodePath1 );
							this.DropSpotTree.setSelectionPath ( NodePath2 );
						}
					}
				}
			}
		}
		
	}
}
