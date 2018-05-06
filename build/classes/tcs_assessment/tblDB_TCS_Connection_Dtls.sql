USE [DB_TCS]
GO

/****** Object:  Table [dbo].[tblDB_TCS_Connection_Dtls]    Script Date: 05-Mar-18 9:07:01 PM ******/
SET ANSI_NULLS ON
GO

SET QUOTED_IDENTIFIER ON
GO

SET ANSI_PADDING ON
GO

CREATE TABLE [dbo].[tblDB_TCS_Connection_Dtls](
	[Mobile_Number] [numeric](10, 0) NOT NULL,
	[Customer_Id] [int] NULL,
	[Tariff_Id] [int] NULL,
	[Connection_Type] [varchar](50) NOT NULL,
 CONSTRAINT [PK_tblDB_TCS_Connection_Dtls] PRIMARY KEY CLUSTERED 
(
	[Mobile_Number] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO

SET ANSI_PADDING OFF
GO

ALTER TABLE [dbo].[tblDB_TCS_Connection_Dtls]  WITH CHECK ADD  CONSTRAINT [FK_tblConnection_Dtls_tblDB_TCS_Customer_Dtls] FOREIGN KEY([Customer_Id])
REFERENCES [dbo].[tblDB_TCS_Customer_Dtls] ([Customer_Id])
GO

ALTER TABLE [dbo].[tblDB_TCS_Connection_Dtls] CHECK CONSTRAINT [FK_Connection_Dtls_tblDB_TCS_Customer_Dtls]
GO

ALTER TABLE [dbo].[tblDB_TCS_Connection_Dtls]  WITH CHECK ADD CHECK  (([Connection_Type]='Prepaid' OR [Connection_Type]='Postpaid'))
GO