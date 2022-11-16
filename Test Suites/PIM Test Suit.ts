<?xml version="1.0" encoding="UTF-8"?>
<TestSuiteEntity>
   <description></description>
   <name>PIM Test Suit</name>
   <tag></tag>
   <isRerun>false</isRerun>
   <mailRecipient></mailRecipient>
   <numberOfRerun>0</numberOfRerun>
   <pageLoadTimeout>30</pageLoadTimeout>
   <pageLoadTimeoutDefault>true</pageLoadTimeoutDefault>
   <rerunFailedTestCasesOnly>false</rerunFailedTestCasesOnly>
   <rerunImmediately>true</rerunImmediately>
   <testSuiteGuid>e25fa840-2223-447d-a737-58e870f02046</testSuiteGuid>
   <testCaseLink>
      <guid>21130240-ec4f-4ce5-b6bc-07efab1ef462</guid>
      <isReuseDriver>false</isReuseDriver>
      <isRun>true</isRun>
      <iterationNameVariable>
         <defaultValue>'Employment Status'</defaultValue>
         <description></description>
         <id>15f7c783-7dde-4609-b0da-84765d1be446</id>
         <masked>false</masked>
         <name>status</name>
      </iterationNameVariable>
      <testCaseId>Test Cases/PIM-001-Search employee</testCaseId>
      <testDataLink>
         <combinationType>ONE</combinationType>
         <id>9db6e7d8-545c-4a8e-90d1-ec6edb48ae82</id>
         <iterationEntity>
            <iterationType>RANGE</iterationType>
            <value>1-2</value>
         </iterationEntity>
         <testDataId>Data Files/EmployeeSearch</testDataId>
      </testDataLink>
      <testDataLink>
         <combinationType>MANY</combinationType>
         <id>e27f4bc9-4b12-4517-9c39-02509e06e428</id>
         <iterationEntity>
            <iterationType>SPECIFIC</iterationType>
            <value>1</value>
         </iterationEntity>
         <testDataId>Data Files/EmployeeFields</testDataId>
      </testDataLink>
      <usingDataBindingAtTestSuiteLevel>true</usingDataBindingAtTestSuiteLevel>
      <variableLink>
         <testDataLinkId>e27f4bc9-4b12-4517-9c39-02509e06e428</testDataLinkId>
         <type>DATA_COLUMN</type>
         <value>Status</value>
         <variableId>15f7c783-7dde-4609-b0da-84765d1be446</variableId>
      </variableLink>
      <variableLink>
         <testDataLinkId>9db6e7d8-545c-4a8e-90d1-ec6edb48ae82</testDataLinkId>
         <type>DATA_COLUMN</type>
         <value>EmpStatus</value>
         <variableId>670674c8-831e-4eb1-b097-76f751937a30</variableId>
      </variableLink>
      <variableLink>
         <testDataLinkId>e27f4bc9-4b12-4517-9c39-02509e06e428</testDataLinkId>
         <type>DATA_COLUMN</type>
         <value>Include</value>
         <variableId>ee16f5a3-889b-4b33-888e-08135583d0cb</variableId>
      </variableLink>
      <variableLink>
         <testDataLinkId>9db6e7d8-545c-4a8e-90d1-ec6edb48ae82</testDataLinkId>
         <type>DATA_COLUMN</type>
         <value>IncludeValue</value>
         <variableId>642718d7-ae91-45e9-938b-c92018241ac6</variableId>
      </variableLink>
      <variableLink>
         <testDataLinkId>9db6e7d8-545c-4a8e-90d1-ec6edb48ae82</testDataLinkId>
         <type>DATA_COLUMN</type>
         <value>Result</value>
         <variableId>d1f642cf-5bc8-4591-b688-cf7f10eb9646</variableId>
      </variableLink>
   </testCaseLink>
   <testCaseLink>
      <guid>979bd924-be7f-4f00-910f-14030d8a5adc</guid>
      <isReuseDriver>false</isReuseDriver>
      <isRun>true</isRun>
      <testCaseId>Test Cases/PIM-002-Search employee with no result</testCaseId>
      <testDataLink>
         <combinationType>ONE</combinationType>
         <id>5b08c0ac-665d-4ac4-b6d8-de52726ad9d6</id>
         <iterationEntity>
            <iterationType>SPECIFIC</iterationType>
            <value>1</value>
         </iterationEntity>
         <testDataId>Data Files/EmployeeFields</testDataId>
      </testDataLink>
      <testDataLink>
         <combinationType>ONE</combinationType>
         <id>8ba58633-888c-4347-9db8-301988b3af65</id>
         <iterationEntity>
            <iterationType>SPECIFIC</iterationType>
            <value>3</value>
         </iterationEntity>
         <testDataId>Data Files/EmployeeSearch</testDataId>
      </testDataLink>
      <usingDataBindingAtTestSuiteLevel>true</usingDataBindingAtTestSuiteLevel>
      <variableLink>
         <testDataLinkId>5b08c0ac-665d-4ac4-b6d8-de52726ad9d6</testDataLinkId>
         <type>DATA_COLUMN</type>
         <value>Id</value>
         <variableId>0dd731db-c2e5-41e0-85ae-ae25ad8a59e1</variableId>
      </variableLink>
      <variableLink>
         <testDataLinkId>8ba58633-888c-4347-9db8-301988b3af65</testDataLinkId>
         <type>DATA_COLUMN</type>
         <value>EmpId</value>
         <variableId>496155a3-8afe-421c-8c69-9a942722466c</variableId>
      </variableLink>
      <variableLink>
         <testDataLinkId>5b08c0ac-665d-4ac4-b6d8-de52726ad9d6</testDataLinkId>
         <type>DATA_COLUMN</type>
         <value>name</value>
         <variableId>954a5094-90f1-4b05-b0b5-a4d6d3f845d0</variableId>
      </variableLink>
      <variableLink>
         <testDataLinkId>8ba58633-888c-4347-9db8-301988b3af65</testDataLinkId>
         <type>DATA_COLUMN</type>
         <value>EmpName</value>
         <variableId>5cee0475-8dfa-4693-9815-de711955215a</variableId>
      </variableLink>
      <variableLink>
         <testDataLinkId>5b08c0ac-665d-4ac4-b6d8-de52726ad9d6</testDataLinkId>
         <type>DATA_COLUMN</type>
         <value>Status</value>
         <variableId>15f7c783-7dde-4609-b0da-84765d1be446</variableId>
      </variableLink>
      <variableLink>
         <testDataLinkId>8ba58633-888c-4347-9db8-301988b3af65</testDataLinkId>
         <type>DATA_COLUMN</type>
         <value>EmpStatus</value>
         <variableId>309e3e52-1c00-45d8-a925-d0823202deb5</variableId>
      </variableLink>
      <variableLink>
         <testDataLinkId>5b08c0ac-665d-4ac4-b6d8-de52726ad9d6</testDataLinkId>
         <type>DATA_COLUMN</type>
         <value>Include</value>
         <variableId>ee16f5a3-889b-4b33-888e-08135583d0cb</variableId>
      </variableLink>
      <variableLink>
         <testDataLinkId>8ba58633-888c-4347-9db8-301988b3af65</testDataLinkId>
         <type>DATA_COLUMN</type>
         <value>IncludeValue</value>
         <variableId>642718d7-ae91-45e9-938b-c92018241ac6</variableId>
      </variableLink>
      <variableLink>
         <testDataLinkId>5b08c0ac-665d-4ac4-b6d8-de52726ad9d6</testDataLinkId>
         <type>DATA_COLUMN</type>
         <value>Job</value>
         <variableId>1fe51803-ac16-4c22-80d5-4584041cbdf1</variableId>
      </variableLink>
      <variableLink>
         <testDataLinkId>8ba58633-888c-4347-9db8-301988b3af65</testDataLinkId>
         <type>DATA_COLUMN</type>
         <value>JobTitle</value>
         <variableId>3a74e12a-2d16-4728-998c-95d285e8d557</variableId>
      </variableLink>
      <variableLink>
         <testDataLinkId>5b08c0ac-665d-4ac4-b6d8-de52726ad9d6</testDataLinkId>
         <type>DATA_COLUMN</type>
         <value>Unit</value>
         <variableId>54e839cb-94ab-4705-96f9-5ec54eb89624</variableId>
      </variableLink>
      <variableLink>
         <testDataLinkId>8ba58633-888c-4347-9db8-301988b3af65</testDataLinkId>
         <type>DATA_COLUMN</type>
         <value>SubUnit</value>
         <variableId>878f43dd-6c83-4185-9d00-7c647f4ec077</variableId>
      </variableLink>
      <variableLink>
         <testDataLinkId>8ba58633-888c-4347-9db8-301988b3af65</testDataLinkId>
         <type>DATA_COLUMN</type>
         <value>Result</value>
         <variableId>d1f642cf-5bc8-4591-b688-cf7f10eb9646</variableId>
      </variableLink>
   </testCaseLink>
   <testCaseLink>
      <guid>b6a24353-11f7-40ff-a9de-ebe9b8fa7aa3</guid>
      <isReuseDriver>false</isReuseDriver>
      <isRun>true</isRun>
      <testCaseId>Test Cases/PIM-003-Apply new leave</testCaseId>
      <usingDataBindingAtTestSuiteLevel>true</usingDataBindingAtTestSuiteLevel>
   </testCaseLink>
   <testCaseLink>
      <guid>7dcc5a0d-2921-4456-b0d6-199197e568b4</guid>
      <isReuseDriver>false</isReuseDriver>
      <isRun>true</isRun>
      <testCaseId>Test Cases/PIM-004-Import export file</testCaseId>
      <usingDataBindingAtTestSuiteLevel>false</usingDataBindingAtTestSuiteLevel>
   </testCaseLink>
</TestSuiteEntity>
