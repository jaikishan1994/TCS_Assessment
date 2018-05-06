USE [DB_TCS]
GO

/****** Object:  Table [dbo].[tblDB_TCS_Customer_Dtls]    Script Date: 05-Mar-18 9:07:48 PM ******/
SET ANSI_NULLS ON
GO

SET QUOTED_IDENTIFIER ON
GO

SET ANSI_PADDING ON
GO

CREATE TABLE [dbo].[tblDB_TCS__Customer_Dtls](
	[Customer_Id] [int] NOT NULL,
	[Customer_Name] [varchar](25) NOT NULL,
	[Gender] [char](1) NOT NULL,
	[Age] [int] NOT NULL,
	[emailId] [varchar](25) NOT NULL,
	[Address] [varchar](25) NOT NULL,
 CONSTRAINT [PK_tblDB_TCS__Customer_Dtls] PRIMARY KEY CLUSTERED 
(
	[Customer_Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO

SET ANSI_PADDING OFF
GO